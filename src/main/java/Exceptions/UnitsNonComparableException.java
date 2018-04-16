package Exceptions;

public class UnitsNonComparableException extends Exception {
	private static final long serialVersionUID = -1L;
	public UnitsNonComparableException(){
		System.out.println("Exception : l'Unit est non comparable");
	}
}