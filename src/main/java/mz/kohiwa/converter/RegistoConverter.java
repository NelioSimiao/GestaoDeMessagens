package mz.kohiwa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import mz.kohiwa.model.DocRegisto;
import mz.kohiwa.repository.Registos;

@FacesConverter(forClass = DocRegisto.class)
public class RegistoConverter implements Converter {

	@Inject
	public Registos registos;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		DocRegisto docRegistoRetornado = null;
		if (StringUtils.isNotEmpty(value)) {
			Long id = Long.valueOf(value);
			docRegistoRetornado = registos.porId(id);
		}
		return docRegistoRetornado;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			return String.valueOf(((DocRegisto) value).getId());
		}
		return null;
	};

}
