package Exceptions;

public class ColonnePasTrouveException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	public ColonnePasTrouveException(String titre) {
		System.err.println("La colonne \""+titre+"\" n'existe pas.");
	}
}
