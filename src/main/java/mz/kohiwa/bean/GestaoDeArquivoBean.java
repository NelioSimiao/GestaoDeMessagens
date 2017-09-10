package mz.kohiwa.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import mz.kohiwa.model.DocRegisto;
import mz.kohiwa.model.Mensagem;
import mz.kohiwa.model.SMS;
import mz.kohiwa.repository.Registos;
import mz.kohiwa.util.jsf.FacesUtil;

@Named
@ViewScoped
public class GestaoDeArquivoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private DocRegisto docRegisto;
	@Inject
	private Registos registos;
	private UploadedFile file;

	public GestaoDeArquivoBean() {
		docRegisto = new DocRegisto();
		docRegisto.setMensagem(new Mensagem());
		docRegisto.setSms(new SMS());
	}

	public void init() {
		if (FacesUtil.isNotPostback()) {
			if (docRegisto == null) {
				docRegisto = new DocRegisto();
				docRegisto.setMensagem(new Mensagem());
				docRegisto.setSms(new SMS());

			}

		}
	}

	public void limpar() {
		docRegisto = new DocRegisto();
		docRegisto.setMensagem(new Mensagem());
		docRegisto.setSms(new SMS());
	}

	/*
	 * public void upload(FileUploadEvent event) { if (arquivoRegistado != null)
	 * { try (InputStream is = arquivoRegistado.getInputstream();
	 * ByteArrayOutputStream out = new ByteArrayOutputStream()) { int read = -1;
	 * byte[] buffer = new byte[1024]; while ((read = is.read(buffer)) != -1) {
	 * out.write(buffer, 0, read);
	 * 
	 * } docRegisto.setDocumento(out.toByteArray());
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block throw new
	 * RuntimeException("Erro ao enviar o documento",e); } }
	 * 
	 * }
	 */
	public void upload(FileUploadEvent event) {
		this.file = event.getFile();
		byte[] arquivoByte = file.getContents();
		System.out.println(file.getFileName() + " is uploaded");
		if (arquivoByte == null) {
			FacesUtil.addInfoMessage("Adicioana o arquivo");
		}
		docRegisto.setDocumento(arquivoByte);

	}

	public void salvar() {
		docRegisto = registos.guardar(docRegisto);
		limpar();
		FacesUtil.addInfoMessage("Registo cadastrado com sucesso");
	}

	public DocRegisto getDocRegisto() {
		return docRegisto;

	}

	public void setDocRegisto(DocRegisto docRegisto) {
		this.docRegisto = docRegisto;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
