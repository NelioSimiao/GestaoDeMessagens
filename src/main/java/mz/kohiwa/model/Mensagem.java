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
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "mensagem")
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date dataDifusaoMensagem;
	private String conselho;
	private String mensagem;
	private BigDecimal precoMensagem;

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

//	@NotBlank
//	@Lob
//	@Column(name = "conselho", nullable = false)
//	public String getConselho() {
//		return Conselho;
//	}
//
//	public void setConselho(String conselho) {
//		Conselho = conselho;
//	}
	

	@NotEmpty
	@Lob
	@Column(name = "mensagem", nullable = false)
	public String getMensagem() {
		return mensagem;
	}
	
	@Transient
	public String getMensagemResumida() {
		return mensagem == null ? "" : StringUtils.left(mensagem, 50) + "...";
	}
	
	@NotBlank
	@Lob
	@Column(name = "conselho", nullable = false)
	public String getConselho() {
		return conselho;
	}
	
	@Transient
	public String getConselhoResumida() {
		return mensagem == null ? "" : StringUtils.left(conselho, 50) + "...";
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	@NotNull
	@Column(name = "preco_mensagem", nullable = false)
	public BigDecimal getPrecoMensagem() {
		return precoMensagem;
	}

	public void setPrecoMensagem(BigDecimal precoMensagem) {
		this.precoMensagem = precoMensagem;
	}

}
