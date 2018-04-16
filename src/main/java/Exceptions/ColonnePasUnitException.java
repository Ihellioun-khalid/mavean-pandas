package Exceptions;

public class ColonnePasUnitException extends Exception {
	private static final long serialVersionUID = -1L;
	public ColonnePasUnitException(){
		System.err.println("l'Unit ne contient aucune data");
	}
}
