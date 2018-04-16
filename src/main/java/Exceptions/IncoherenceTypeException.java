package Exceptions;

public class IncoherenceTypeException extends Exception {
	private static final long serialVersionUID = -1L;
	public IncoherenceTypeException() {
		System.err.println("Exception: il y incoherence dans les types");
	}
}