package Exceptions;

public class ColonnePasTypeException extends Exception {
	public ColonnePasTypeException() {
		System.err.println("Exception : la colonne n'a pas encoure de type precis pour les donnees.");
	}
}
