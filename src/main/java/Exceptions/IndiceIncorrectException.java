package Exceptions;

public class IndiceIncorrectException extends Exception {
	private static final long serialVersionUID = -1L;
	public IndiceIncorrectException () {
		System.err.println("L'indice est incorrect ou il n'existe pas dans la Data Frame");
	}
	
}