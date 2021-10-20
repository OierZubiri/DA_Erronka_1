package Ficheros;

import java.io.*;
import java.util.ArrayList;

import Metodoak.Liburua;

public class FicheroTXT {

	// __________________________________________________________________________________________________________________//

	public static void sartuTXT() {
		ArrayList<Liburua> Libros = Metodoak.Metodoak.getLibros();

		for (int i = 0; i < Libros.size(); i++) {
			System.err.println(Libros.get(i).toString());
		}

		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("./datuak/Liburuak.txt", false));
			fichero.write("------------------------------------------------------" + "\n");
			for (int i = 0; i < Libros.size(); i++) {
				fichero.write(Libros.get(i).toString());
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
		}
	}

	// __________________________________________________________________________________________________________________//

	public static void irakurriTXT() throws InterruptedException {
		ArrayList<Liburua> libros = new ArrayList<>();

		System.out.println("\n" + "------------------------------------------------------");
		System.err.println("TXT Fitxategia");

		try {
			File fic = new File("./datuak/Liburuak.txt");
			BufferedReader fichero = new BufferedReader(new FileReader(fic));
			String linea;

			while ((linea = fichero.readLine()) != null)
				System.out.print(linea + " \n");

			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
		}

		Metodoak.Metodoak.setLibros(libros);

		Thread.sleep(2000);
	}

}