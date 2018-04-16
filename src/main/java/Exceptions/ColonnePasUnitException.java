package Exceptions;

public class ColonnePasUnitException extends Exception {
	public ColonnePasUnitException(){
		System.err.println("l'Unit ne contient aucune data");
	}
}
