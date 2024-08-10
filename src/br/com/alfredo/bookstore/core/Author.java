package br.com.alfredo.bookstore.core;

import br.com.alfredo.bookstore.exceptions.BookStoreException;
import br.com.alfredo.bookstore.intefaces.IDisplayInfo;

public class Author implements IDisplayInfo {

	private int id;
	private String name;
	private String email;

	public Author() {
	};

	public int getId() {
		return id;
	}

	public void setId(int id) throws BookStoreException {
		if (id <= 0) {
			throw new BookStoreException("ID cannot be a negative number");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws BookStoreException {
		if (name == null || name.trim().length() == 0) {
			throw new BookStoreException("Name cannot be empty");
		}
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.id + ";" + this.name + ";" + this.email;
	}

	@Override
	public String displayInfo() {
		return "ID: " + this.id + " | NAME: " + this.name + " | EMAIL: " + this.email;
	}
}