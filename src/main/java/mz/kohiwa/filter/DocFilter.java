package mz.kohiwa.filter;

import java.io.Serializable;

public class DocFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	private String conselho;

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

}
