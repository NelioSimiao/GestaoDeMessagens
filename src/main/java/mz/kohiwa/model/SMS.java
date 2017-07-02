package mz.kohiwa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SMS implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dataDifusaoSMS;
	private String SMS;
	private String distrito;
	private BigDecimal precoSMS;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDifusaoSMS() {
		return dataDifusaoSMS;
	}

	public void setDataDifusaoSMS(Date dataDifusaoSMS) {
		this.dataDifusaoSMS = dataDifusaoSMS;
	}

	public String getSMS() {
		return SMS;
	}

	public void setSMS(String sMS) {
		SMS = sMS;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public BigDecimal getPrecoSMS() {
		return precoSMS;
	}

	public void setPrecoSMS(BigDecimal precoSMS) {
		this.precoSMS = precoSMS;
	}

}
