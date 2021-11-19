package Metodoak;

import java.util.ArrayList;
import java.util.Scanner;


public class MetodoLiburuak {

	// __________________________________________________________________________________________________________________//

	public static ArrayList<Liburua> Libros = new ArrayList<>();

	// __________________________________________________________________________________________________________________//

	public static ArrayList<Liburua> getLibros() {
		return Libros;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean setLibros(ArrayList<Liburua> libros) {
		Libros = libros;
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean sartutakoLiburua(Liburua l1) {

		System.out.println("\n" + "----------------SARTUTAKO LIBURUA---------------------");
		System.out.println(l1.toString());
		System.out.println("------------------------------------------------------");

		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static Liburua gehituLiburu(Scanner sc) {
		boolean ondo = false;

		String izenburua = null, argitaletxea = null, orrialdeak = null, altuera = null, oharrak = null, ISBN = null,
				gaiak = null;

		izenburua = MetodoKomprobaketak.izenburua(ondo, sc);
		argitaletxea = MetodoKomprobaketak.argitaletxea(ondo, sc);
		orrialdeak = MetodoKomprobaketak.orrialdeak(ondo, sc);
		altuera = MetodoKomprobaketak.altuera(ondo, sc);
		oharrak = MetodoKomprobaketak.oharrak(ondo, sc);
		ISBN = MetodoKomprobaketak.ISBN(ondo, sc);
		gaiak = MetodoKomprobaketak.gaiak(ondo, sc);

		return new Liburua(izenburua, argitaletxea, orrialdeak, altuera, oharrak, ISBN, gaiak);
	}
}