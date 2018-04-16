package Exceptions;

import com.sun.org.apache.bcel.internal.generic.Type;

public class NonCalculableException extends Exception {
	private static final long serialVersionUID = -1L;
	public NonCalculableException() {
		System.err.println("La colonne n'est pas calculable !");
	}

}