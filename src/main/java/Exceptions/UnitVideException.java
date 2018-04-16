package Exceptions;

public class UnitVideException extends Exception {
	private static final long serialVersionUID = -1L;
	public UnitVideException(){
		System.out.println("Exception : l'unit est vide!");
	}
}
