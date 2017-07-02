package mz.kohiwa.model;

import java.io.Serializable;

public class DocumentoCompleto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	
	private Mensagem mensagem;
	
	private SMS sms;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	public SMS getSms() {
		return sms;
	}
	public void setSms(SMS sms) {
		this.sms = sms;
	}
	
	

}
