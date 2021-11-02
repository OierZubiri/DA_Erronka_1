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

		izenburua = izenburua(ondo, sc);
		argitaletxea = argitaletxea(ondo,sc);
		orrialdeak = orrialdeak(ondo, sc);
		altuera = altuera(ondo, sc);
		oharrak = oharrak(ondo, sc);
		ISBN = ISBN(ondo, sc);
		gaiak = gaiak(ondo, sc); 

		return new Liburua(izenburua, argitaletxea, orrialdeak, altuera, oharrak, ISBN, gaiak);
	}

	//***************************************************************************************************************************//

	public static String izenburua(boolean ondo, Scanner sc) {
		String izenburua;
		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu izenburua");
			izenburua = sc.nextLine();
			Matcher m = p.matcher(izenburua);
			if(m.matches()) 
				ondo = true;  
		} while (!ondo);
		return izenburua;
	}

	//***************************************************************************************************************************//

	public static String argitaletxea(boolean ondo, Scanner sc) {
		String argitaletxea;
		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu argitaletxea");
			argitaletxea = sc.nextLine(); 
			Matcher m = p.matcher(argitaletxea);
			if(m.matches()) 
				ondo = true; 
		} while (!ondo);
		return argitaletxea;
	}

	//***************************************************************************************************************************//

	public static String orrialdeak(boolean ondo, Scanner sc) {
		String orrialdeak;
		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakia);
			System.out.println("Sartu orrialdeak");
			orrialdeak = sc.nextLine();
			Matcher m = p.matcher(orrialdeak);
			if(m.matches()) 
				ondo = true; 
		} while (!ondo);
		return orrialdeak;
	}

	//***************************************************************************************************************************//

	public static String altuera(boolean ondo, Scanner sc) {
		String altuera;
		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakia);
			System.out.println("Sartu altuera");
			altuera = sc.nextLine();
			Matcher m = p.matcher(altuera);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);
		return altuera;
	}

	//***************************************************************************************************************************//

	public static String oharrak(boolean ondo, Scanner sc) {
		String oharrak;
		do { 
			Pattern p = Pattern.compile(MetodoakPatroiak.texto);
			System.out.println("Sartu oharrak");
			oharrak = sc.nextLine();
			Matcher m = p.matcher(oharrak);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);
		return oharrak;
	}

	//***************************************************************************************************************************//

	public static String ISBN(boolean ondo, Scanner sc) {
		String ISBN;
		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.ISBN);
			System.out.println("Sartu ISBN");
			ISBN = sc.nextLine();
			Matcher m = p.matcher(ISBN);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);
		return ISBN;
	}

	//***************************************************************************************************************************//

	public static String gaiak(boolean ondo, Scanner sc) {
		String gaiak;
		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.izena);
			System.out.println("Sartu gaiak");
			gaiak = sc.nextLine();
			Matcher m = p.matcher(gaiak);
			if(m.matches()) 
				ondo = true;
		} while (!ondo);
		return gaiak;
	}

	//***************************************************************************************************************************//

	/*public static boolean bilatuLiburua(Scanner sc) {
		boolean zenbkiOna = false;
		String zbk;

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaBilatu);
			do {
				zenbkiOna = true;
				System.out.println("Zerekin bilatu nahi duzu?\n" + "1--> Izenburua\n" + "2--> Argitaletxea\n" + "3--> Orrialdeak\n"
						+ "4--> Altuera\n" + "5--> Oharrak\n" + "6--> ISBN\n" + "7--> Gaia");
				zbk = sc.nextLine(); 
				Matcher m = p.matcher(zbk);
				if(m.matches()) 
					zenbkiOna = false; 
			} while (zenbkiOna);

			switch (Integer.parseInt(zbk)) {

			case 1: 
				aukera("Izenburua",sc);
				zenbkiOna = false;
				break;
			case 2: 
				aukera("Argitaletxea",sc);
				zenbkiOna = false;
				break;
			case 3:
				aukera("Orrialdeak",sc);
				zenbkiOna = false;
				break;
			case 4: 
				aukera("Altuera",sc);
				zenbkiOna = false;
				break;
			case 5: 
				aukera("Oharrak",sc);
				zenbkiOna = false;
				break;
			case 6: 
				aukera("ISBN",sc);
				zenbkiOna = false;
				break;
			case 7: 
				aukera("Gaia",sc);
				zenbkiOna = false;
				break;
			default:
				System.out.println("Sartu 1 eta 7 artean egon behar da");
			}
		} while (zenbkiOna);
		
		return true;
	}*/

	//***************************************************************************************************************************//
	
	/*public static void aukera(String aukeratua, Scanner sc) {
		String pat="";   
		for(int i=0;i<Libros.size();i++) { 
			System.err.println(aukeratua);
			if(aukeratua.equals("Izenburua")) { 
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getIzenburua()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Argitaletxea")) { 
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getArgitaletxea()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Orrialdeak")) {
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getOrrialdeak()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Altuera")) {
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getAltuera()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Oharrak")) {
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getOharrak()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("ISBN")) {
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getISBN()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Gaia")) {
				System.out.println("Esan "+aukeratua+":");
				pat=sc.nextLine();
				if(pat.equals(Libros.get(i).getGaiak()))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			}
		}
	} */
} 