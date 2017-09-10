package mz.kohiwa.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import mz.kohiwa.filter.DocFilter;
import mz.kohiwa.model.DocRegisto;
import mz.kohiwa.repository.Registos;
import mz.kohiwa.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquidaGestaoDeArquivoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private DocRegisto docRegisto;
	private DocRegisto docRegistoSelecionado;
	private StreamedContent download;
	private DocFilter filter;
	@Inject
	private Registos registos;
	private List<DocRegisto> registosfiltrado;
	private List<DocRegisto> docSelecionados;

	@Inject
	EntityManager manager;


	public PesquidaGestaoDeArquivoBean() {
		docRegisto = new DocRegisto();
		filter= new DocFilter();
	}

	public void limpar() {
		docRegisto = new DocRegisto();
	}

	public void pesquisar() {
		registosfiltrado = registos.registosFiltrados(filter);

	}

	public void excluir() {
		registos.remover(docRegistoSelecionado);
		registosfiltrado.remove(docRegistoSelecionado);
		FacesUtil.addInfoMessage("Registo removido com sucesso.");

	}

	public StreamedContent downloadDoc( Long id) {
		docRegistoSelecionado = porId(id);
		String nomeArquivo = "document" + docRegistoSelecionado.getId() + ".pdf";
		InputStream stream = new ByteArrayInputStream(docRegistoSelecionado.getDocumento());
		return download = new DefaultStreamedContent(stream, "application/pdf", nomeArquivo);
	}

	public DocRegisto getDocRegisto() {

		return docRegisto;
	}

	public DocRegisto getdocSelecionado() {

		return docRegisto;
	}

	public void setdocSelecionado(DocRegisto docRegisto) {
		this.docRegisto = docRegisto;
	}

	public void setDocRegisto(DocRegisto docRegisto) {
		this.docRegisto = docRegisto;
	}

	public List<DocRegisto> getRegistosfiltrado() {
		return registosfiltrado;
	}

	public void setRegistosfiltrado(List<DocRegisto> registosfiltrado) {
		this.registosfiltrado = registosfiltrado;
	}

	public Registos getRegistos() {
		return registos;
	}

	public void setRegistos(Registos registos) {
		this.registos = registos;
	}

	public List<DocRegisto> getDocSelecionados() {
		return docSelecionados;
	}

	public void setDocSelecionados(List<DocRegisto> docSelecionados) {
		this.docSelecionados = docSelecionados;
	}

	public DocRegisto getDocRegistoSelecionado() {
		return docRegistoSelecionado;
	}

	public void setDocRegistoSelecionado(DocRegisto docRegistoSelecionado) {
		this.docRegistoSelecionado = docRegistoSelecionado;
	}

	public StreamedContent getDownload() {
		return download;
	}

	public void setDownload(StreamedContent download) {
		this.download = download;
	}
	
	public DocRegisto porId(Long id) {
		return manager.find(DocRegisto.class, id);
	}

	public DocFilter getFilter() {
		return filter;
	}

	public void setFilter(DocFilter filter) {
		this.filter = filter;
	}
	

}
