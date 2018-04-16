package Exceptions;

public class ColonnePasTrouveException extends Exception {
	public ColonnePasTrouveException(String titre) {
		System.err.println("La colonne \""+titre+"\" n'existe pas.");
	}
}
