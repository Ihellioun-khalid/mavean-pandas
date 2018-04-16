package Exceptions;

public class ColonneNonComparableException extends Exception {
	private static final long serialVersionUID = -1L;
	public ColonneNonComparableException(){
		System.err.println("Exception : la colonne est non comparable!");
	}
}