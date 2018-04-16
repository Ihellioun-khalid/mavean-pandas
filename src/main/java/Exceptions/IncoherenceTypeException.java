package Exceptions;

public class IncoherenceTypeException extends Exception {
	public IncoherenceTypeException() {
		System.err.println("Exception: il y incoherence dans les types");
	}
}