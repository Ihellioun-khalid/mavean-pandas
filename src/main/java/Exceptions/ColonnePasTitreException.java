package Exceptions;

public class ColonnePasTitreException extends Exception {
	private static final long serialVersionUID = -1L;
	public ColonnePasTitreException() {
		System.err.println("Exception : La colonne n'a pas de titre.");
	}	
	
}
