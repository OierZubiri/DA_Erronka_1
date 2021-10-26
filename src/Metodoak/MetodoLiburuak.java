package Metodoak;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class MetodoLiburuak {

	//***************************************************************************************************************************//

	public static ArrayList<Liburua> Libros = new ArrayList<>();

	//***************************************************************************************************************************//

	public static ArrayList<Liburua> getLibros() {
		return Libros;
	}

	//***************************************************************************************************************************//

	public static boolean setLibros(ArrayList<Liburua> libros) {
		Libros = libros;
		return true;
	} 

	//***************************************************************************************************************************//

	public static boolean sartutakoLiburua(Liburua l1) {

		System.out.println("\n" + "----------------SARTUTAKO LIBURUA---------------------");
		System.out.println(l1.toString());
		System.out.println("------------------------------------------------------");

		return true;
	}

	//***************************************************************************************************************************//

	public static Liburua gehituLiburu(Scanner sc) {
		boolean ondo = false;

		String izenburua = null, argitaletxea = null, orrialdeak = null, altuera = null, oharrak = null, ISBN = null,
				gaiak = null;

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu izenburua");
			izenburua = sc.nextLine();
			Matcher m = p.matcher(izenburua);
			if(m.matches()) 
				ondo = true;  
		} while (!ondo);

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu argitaletxea");
			argitaletxea = sc.nextLine(); 
			Matcher m = p.matcher(argitaletxea);
			if(m.matches()) 
				ondo = true; 
		} while (!ondo);

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakia);
			System.out.println("Sartu orrialdeak");
			orrialdeak = sc.nextLine();
			Matcher m = p.matcher(orrialdeak);
			if(m.matches()) 
				ondo = true; 
		} while (!ondo);

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakia);
			System.out.println("Sartu altuera");
			altuera = sc.nextLine();
			Matcher m = p.matcher(orrialdeak);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);

		do { 
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu oharrak");
			oharrak = sc.nextLine();
			Matcher m = p.matcher(oharrak);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.ISBN);
			System.out.println("Sartu ISBN");
			ISBN = sc.nextLine();
			Matcher m = p.matcher(ISBN);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu gaiak");
			gaiak = sc.nextLine();
			Matcher m = p.matcher(gaiak);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);

		return new Liburua(izenburua, argitaletxea, orrialdeak, altuera, oharrak, ISBN, gaiak);
	}
}
