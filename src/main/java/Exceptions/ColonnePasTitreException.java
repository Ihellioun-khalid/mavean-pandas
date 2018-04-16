package Exceptions;

public class ColonnePasTitreException extends Exception {
	public ColonnePasTitreException() {
		System.err.println("Exception : La colonne n'a pas de titre.");
	}	
	
}
