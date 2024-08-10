package br.com.alfredo.bookstore.core;

import br.com.alfredo.bookstore.exceptions.BookStoreException;
import br.com.alfredo.bookstore.intefaces.IDisplayInfo;

public class Book implements IDisplayInfo {

	private int id;
	private String title;
	private Author author;
	private Publisher publisher;
	private double price;

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws BookStoreException {
		if (id <= 0) {
			throw new BookStoreException("Book ID cannot be negative or zero");
		}
		this.id = id;
	}

	public String getTitulo() {
		return title;
	}

	public void setTitle(String title) throws BookStoreException {
		if (title == null || title.trim().length() == 0) {
			throw new BookStoreException("The Book Title cannot be empty");
		}
		this.title = title;
	}

	public Author getauthor() {
		return author;
	}

	public void setauthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void setPrice(double price) throws Exception {
		if (price <= 0) {
			throw new Exception("Erro");
		}
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return id + ";" + title + ";" + author.toString() + ";" + publisher.toString();
	}

	@Override
	public String displayInfo() {
		return "ID: " + this.id
				+ " | TITLE: " + this.title
				+ " | AUTHOR: " + this.author.getName()
				+ " | PUBLISHER: " + this.publisher.getName();
	}

}
