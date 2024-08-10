package br.com.alfredo.bookstore.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.alfredo.bookstore.intefaces.ISaveData;

public class WriteFile<T> implements ISaveData  {

	private String filePath;
	private List<T> array;

	public WriteFile(String filePath, List<T> array) {
		this.filePath = filePath;
		this.array = array;
	}

	@Override
	public void saveData() {
		try {
			File newFile = new File(this.filePath);
			FileWriter newFileWriter = new FileWriter(newFile);
			PrintWriter newPrintWriter = new PrintWriter(newFileWriter);

			for (T a: this.array) {
				newPrintWriter.println(a);
			}
			newPrintWriter.close();
			newFileWriter.close();
			System.out.println("Informations Saved");

		} catch (IOException e) {
			System.out.println("Error while saving the file: " + e.getMessage());

		}

	}

}