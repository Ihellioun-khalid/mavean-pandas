package Exceptions;

public class ColonnePasTypeException extends Exception {
	private static final long serialVersionUID = -1L;
	public ColonnePasTypeException() {
		System.err.println("Exception : la colonne n'a pas encoure de type precis pour les donnees.");
	}
}
