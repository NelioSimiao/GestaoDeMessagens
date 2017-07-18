package mz.kohiwa.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import mz.kohiwa.model.DocRegisto;
import mz.kohiwa.model.Mensagem;
import mz.kohiwa.model.SMS;

@Named
@RequestScoped
public class GestaoDeArquivoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private DocRegisto docRegisto;
	private SMS sms;
	private Mensagem mensagem;

	public GestaoDeArquivoBean() {
		docRegisto = new DocRegisto();
		sms = new SMS();
		mensagem = new Mensagem();
		docRegisto.setMensagem(mensagem);
		docRegisto.setSms(sms);
	}

	public void salvar() {

	}

	public DocRegisto getDocRegisto() {
		return docRegisto;
	}

	public void setDocRegisto(DocRegisto docRegisto) {
		this.docRegisto = docRegisto;
	}

	public SMS getSms() {
		return sms;
	}

	public void setSms(SMS sms) {
		this.sms = sms;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

}
