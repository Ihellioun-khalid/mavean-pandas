package Exceptions;

public class IndiceGrandException extends Exception {

	public IndiceGrandException() {
		System.err.println("L'indice est incorrect ou il n'existe pas dans la Data Frame");
	}

}