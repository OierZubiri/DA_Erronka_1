package Ficheros;

import java.io.*;
import java.util.ArrayList;

import Metodoak.Liburua;

public class FicheroTXT {

	// __________________________________________________________________________________________________________________//

	public static boolean sartuTXT() {
		ArrayList<Liburua> Libros = Metodoak.MetodoLiburuak.getLibros();
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("./datuak/Liburuak.txt",true));
			for (int i = Libros.size()-1; i < Libros.size(); i++) {
				fichero.write(Libros.get(i).toString());
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean irakurriTXT() throws InterruptedException {
		ArrayList<Liburua> libros = new ArrayList<>();

		System.out.println("\n" + "------------------------------------------------------");
		Thread.sleep(100);
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

		Metodoak.MetodoLiburuak.setLibros(libros);
		Thread.sleep(1000);
		return true;
	}

}