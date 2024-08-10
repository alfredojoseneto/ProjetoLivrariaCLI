package br.com.alfredo.bookstore.exceptions;

public class BookStoreException extends Exception {
	
	private static final long serialVersionUID = 1L; 

	public BookStoreException(String message) {
		super(message);
	}
}
