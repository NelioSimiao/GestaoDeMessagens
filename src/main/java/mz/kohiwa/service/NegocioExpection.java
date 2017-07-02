package mz.kohiwa.service;

public class NegocioExpection  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NegocioExpection(String msg){
		super(msg);
	}

}
