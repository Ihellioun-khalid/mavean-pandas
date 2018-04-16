package Exceptions;

public class ColonneVideException extends Exception {
	private static final long serialVersionUID = -1L;
	public ColonneVideException(){
		System.err.println("Exception : la colonne est vide!");
	}
}
