package mz.kohiwa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dataDifusaoMensagem;
	private String Conselho;
	private String mensagem;
	private BigDecimal precoSMS;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDifusaoMensagem() {
		return dataDifusaoMensagem;
	}

	public void setDataDifusaoMensagem(Date dataDifusaoMensagem) {
		this.dataDifusaoMensagem = dataDifusaoMensagem;
	}

	public String getConselho() {
		return Conselho;
	}

	public void setConselho(String conselho) {
		Conselho = conselho;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public BigDecimal getPrecoSMS() {
		return precoSMS;
	}

	public void setPrecoSMS(BigDecimal precoSMS) {
		this.precoSMS = precoSMS;
	}

}
