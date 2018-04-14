package Exceptions;

public class colonnePasTrouveException extends Exception {
	public colonnePasTrouveException(String titre) {
		System.out.println("Exception : la colonne n'a pas trouver.");
	}
}
