package mz.kohiwa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "sms")
public class SMS implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dataDifusaoSMS;
	private String SMS;
	private String distrito;
	private BigDecimal precoSMS;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_difusao_sms", nullable = false)
	public Date getDataDifusaoSMS() {
		return dataDifusaoSMS;
	}

	public void setDataDifusaoSMS(Date dataDifusaoSMS) {
		this.dataDifusaoSMS = dataDifusaoSMS;
	}
	@Lob
	@NotEmpty
	@Column(name = "sms", nullable = false)
	public String getSMS() {
		return SMS;
	}
	
	@Transient
	public String getSmsresumido(){
		return SMS==null?"": StringUtils.left(SMS, 50)+".....";
	}

	public void setSMS(String sMS) {
		SMS = sMS;
	}

	@NotEmpty
	@Column(name = "distrito",nullable=false)
	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@NotNull
	@Column(name = "preco_sms",nullable=false)
	public BigDecimal getPrecoSMS() {
		return precoSMS;
	}

	public void setPrecoSMS(BigDecimal precoSMS) {
		this.precoSMS = precoSMS;
	}

}
