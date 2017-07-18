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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "mensagem")
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date dataDifusaoMensagem;
	private String Conselho;
	private String mensagem;
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
	@Column(name = "data_difusao_messagem", nullable = false)
	public Date getDataDifusaoMensagem() {
		return dataDifusaoMensagem;
	}

	public void setDataDifusaoMensagem(Date dataDifusaoMensagem) {
		this.dataDifusaoMensagem = dataDifusaoMensagem;
	}

	@NotBlank
	@Lob
	@Column(name = "conselho", nullable = false)
	public String getConselho() {
		return Conselho;
	}

	public void setConselho(String conselho) {
		Conselho = conselho;
	}

	@NotBlank
	@Lob
	@Column(name = "mensagem", nullable = false)
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@NotBlank
	@Column(name = "preco_produto", nullable = false)
	public BigDecimal getPrecoSMS() {
		return precoSMS;
	}

	public void setPrecoSMS(BigDecimal precoSMS) {
		this.precoSMS = precoSMS;
	}

}
