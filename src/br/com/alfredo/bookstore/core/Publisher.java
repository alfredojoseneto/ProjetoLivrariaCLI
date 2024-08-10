package br.com.alfredo.bookstore.core;

import br.com.alfredo.bookstore.exceptions.BookStoreException;
import br.com.alfredo.bookstore.intefaces.IDisplayInfo;

public class Publisher implements IDisplayInfo {

	private int id;
	private String name;
	private String phone;

	public Publisher() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws BookStoreException {
		if (id <= 0) {
			throw new BookStoreException("Publisher ID cannot be negative or zero");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws BookStoreException {
		if (name == null || name.trim().length() == 0) {
			throw new BookStoreException("Publisher Name cannot be empty");
		}
		this.name = name;
	}

	public String getTelefone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return id + ";" + name + ";" + phone;
	}

	@Override
	public String displayInfo() {
		return "ID: " + this.id + " | NAME: " + this.name + " | PHONE: " + this.phone;
	}

}
