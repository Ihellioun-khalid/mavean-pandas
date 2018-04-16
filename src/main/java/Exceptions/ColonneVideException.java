package Exceptions;

public class ColonneVideException extends Exception {
	public ColonneVideException(){
		System.err.println("Exception : la colonne est vide!");
	}
}
