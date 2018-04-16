package Exceptions;

public class ColonneNonComparableException extends Exception {
	public ColonneNonComparableException(){
		System.err.println("Exception : la colonne est non comparable!");
	}
}