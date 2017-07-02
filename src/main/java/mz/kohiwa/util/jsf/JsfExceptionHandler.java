package mz.kohiwa.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mz.kohiwa.service.NegocioExpection;

public class JsfExceptionHandler extends ExceptionHandlerWrapper {
	private ExceptionHandler wrapped;
	private static Log log = LogFactory.getLog(JsfExceptionHandler.class);

	public JsfExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			Throwable exception = context.getException();
			NegocioExpection negocioException = getNegocioException(exception);
			boolean handle = false;
			try {
				if (exception instanceof ViewExpiredException) {
					handle = true;
					redirect("/Home.xhtml");
				} else if (negocioException != null) {
					handle= true;
					log.error("Erro de sistema: " + exception.getMessage(), exception);
					FacesUtil.addErrorMessage(negocioException.getMessage());

				} else {
					handle = true;
					redirect("/Erro.xhtml");
				}
			} finally {
				if (handle) {
					events.remove();
				}
			}
		}

		getWrapped().handle();
	}

	private NegocioExpection getNegocioException(Throwable exception) {
		if (exception instanceof NegocioExpection)
			return (NegocioExpection) exception;
		else if (exception.getCause() != null) {
			return getNegocioException(exception.getCause());
		}
		return null;
	}

	private void redirect(String page) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();

			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

}
