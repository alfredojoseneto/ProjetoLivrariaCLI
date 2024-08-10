package br.com.alfredo.bookstore.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.alfredo.bookstore.core.Author;
import br.com.alfredo.bookstore.core.Book;
import br.com.alfredo.bookstore.core.Publisher;
import br.com.alfredo.bookstore.database.WriteFile;
import br.com.alfredo.bookstore.exceptions.BookStoreException;
import br.com.alfredo.bookstore.intefaces.ISaveData;

public class BookStore {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Set<Author> authors = new HashSet<Author>();
		Set<Publisher> publishers = new HashSet<Publisher>();
		List<Book> books = new ArrayList<Book>();

		ISaveData saveAuthor;
		ISaveData savePublisher;
		ISaveData saveBook;

		String answer;

		do {
			System.out.println("Choose an Option:");
			System.out.println("1. Register a Publisher");
			System.out.println("2. Display Publishers");
			System.out.println("3. Save Publishers");
			System.out.println("4. Register an author");
			System.out.println("5. Display authors");
			System.out.println("6. Save authors");
			System.out.println("7. Register a Book");
			System.out.println("8. Display Books");
			System.out.println("9. Save Books");
			System.out.println("q. Sair");

			answer = scanner.nextLine();

			switch (answer) {

			case "1":
				System.out.print("Insert a Publisher ID: ");
				int idPublisher = Integer.parseInt(scanner.nextLine());
				System.out.print("Insert a Publisher Name: ");
				String publisherName = scanner.nextLine();
				System.out.print("Insert a Publisher Phone Number: ");
				String publisherPhone = scanner.nextLine();
				Publisher newPublisher = new Publisher();

				try {
					newPublisher.setId(idPublisher);
					newPublisher.setName(publisherName);
					newPublisher.setPhone(publisherPhone);
					publishers.add(newPublisher);
					System.out.println("Publisher Registered with sucessfull!");
				} catch (BookStoreException e) {
					System.out.println("Something wrong while registering a new Publisher: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Something unexpected while registering a new Publisher: " + e.getMessage());
				}
				break;

			case "2":
				if (publishers.isEmpty()) {
					System.out.println("There is nothing to display");
				} else {
					publishers.forEach((p) -> {
						System.out.println(p.displayInfo());
					});
				}
				break;

			case "3":
				if (publishers.isEmpty()) {
					System.out.println("There is nothing to save");
				} else {
					ArrayList<Publisher> listPublishers = (ArrayList<Publisher>) publishers.stream()
																						   .collect(Collectors.toList());
					savePublisher = new WriteFile<Publisher>("publisher.txt", listPublishers);
					savePublisher.saveData();
				}
				break;

			case "4":
				System.out.print("Insert an Author ID: ");
				int authorID = Integer.parseInt(scanner.nextLine());
				System.out.print("Insert the Author Name: ");
				String authorNome = scanner.nextLine();
				System.out.print("Insert the Author E-mail: ");
				String authorEmail = scanner.nextLine();
				Author novoAuthor = new Author();

				try {
					novoAuthor.setId(authorID);
					novoAuthor.setName(authorNome);
					novoAuthor.setEmail(authorEmail);
					authors.add(novoAuthor);
					System.out.println("Author registered Successfully!");
				} catch (BookStoreException e) {
					System.out.println("Something wrong while registering a new Author: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Something unexpected while registering a new Author: " + e.getMessage());
				}
				break;

			case "5":
				if (authors.isEmpty()) {
					System.out.println("There is nothing to display");
				} else {
					authors.forEach((a) -> {
						System.out.println(a.displayInfo());
					});
				}
				break;

			case "6":
				if (authors.isEmpty()) {
					System.out.println("There is nothing to save");
				} else {
					ArrayList<Author> authorsList = (ArrayList<Author>) authors.stream().collect(Collectors.toList());
					saveAuthor = new WriteFile<Author>("author.txt", authorsList);
					saveAuthor.saveData();
				}
				break;

			case "7":
				System.out.print("Insert the Book Id: ");
				int bookId = Integer.parseInt(scanner.nextLine());
				System.out.print("Insert the Book Title: ");
				String bookTitle = scanner.nextLine();
				authors.forEach((a) -> {
					System.out.println(a.displayInfo());
				});
				System.out.print("Choose the Book Author ID: ");
				int bookAuthorId = Integer.parseInt(scanner.nextLine());
				Author bookAuthor = authors.stream().filter((a) -> a.getId() == bookAuthorId)
						.collect(Collectors.toList()).get(0);
				publishers.forEach((p) -> {
					p.displayInfo();
				});
				System.out.print("Choose the Book Publisher ID: ");
				int bookPublisherId = Integer.parseInt(scanner.nextLine());
				Publisher bookPublisher = publishers.stream().filter((p) -> p.getId() == bookPublisherId)
						.collect(Collectors.toList()).get(0);

				System.out.println("Insert the Book Price");
				double bookPrice = Double.parseDouble(scanner.nextLine());
				try {
					Book newBook = new Book();
					newBook.setId(bookId);
					newBook.setTitle(bookTitle);
					newBook.setauthor(bookAuthor);
					newBook.setPublisher(bookPublisher);
					newBook.setPrice(bookPrice);

					books.add(newBook);

					System.out.println("New Book Registered Successfully!");

				} catch (BookStoreException e) {
					System.out.println("Something wrong while registering the new Book: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Something unexpected while registering the new Book: " + e.getMessage());
				}
				break;

			case "8":
				if (books.isEmpty()) {
					System.out.println("There is nothing to display");
				} else {
					books.forEach((b) -> {
						System.out.println(b.displayInfo());
					});
				}
				break;

			case "9":
				if (books.isEmpty()) {
					System.out.println("There is nothing to save");
				} else {
					ArrayList<Book> bookList = (ArrayList<Book>) books.stream().collect(Collectors.toList());
					saveBook = new WriteFile<Book>("book.txt", bookList);
					saveBook.saveData();
				}
				break;
			}

		} while (!answer.startsWith("q"));

		System.out.println("Encerrando o programa...");

		scanner.close();

	}

}
