package Metodoak;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Ficheros.FicheroDAT;
import Ficheros.FicheroDOM;
import Ficheros.FicheroTXT;


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

	public static boolean bilatuLiburua(Scanner sc) throws InterruptedException {
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
	}

	//***************************************************************************************************************************//

	public static void aukera(String aukeratua, Scanner sc) throws InterruptedException {
		String pat="";  
		System.out.println("Esan "+aukeratua+":");
		pat=sc.nextLine();
		int patam = pat.length();
		for(int i=0;i<Libros.size();i++) {  
			if(aukeratua.equals("Izenburua")) { 	
				
				String laburI = Libros.get(i).getIzenburua().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getIzenburua()) || pat.equals(laburI)) {
						try {
							FicheroDOM.komprobatu(Libros.get(i));
							Thread.sleep(1000);
							System.out.println("------------------------------------------------------");
							System.err.println("DAT");
							System.out.println("------------------------------------------------------");
							FicheroDAT.komprobatu(Libros.get(i));
							Thread.sleep(1000);
						} catch (InterruptedException e) { 
							e.printStackTrace(); 			
					}}
			} if(aukeratua.equals("Argitaletxea")) { 
				
				String laburA = Libros.get(i).getArgitaletxea().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getArgitaletxea()) || pat.equals(laburA))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
						Thread.sleep(1000);
						System.out.println("------------------------------------------------------");
						System.err.println("DAT");
						System.out.println("------------------------------------------------------");
						FicheroDAT.komprobatu(Libros.get(i));
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Orrialdeak")) {
				
				String laburO = Libros.get(i).getOrrialdeak().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getOrrialdeak()) || pat.equals(laburO))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
						Thread.sleep(1000);
						System.out.println("------------------------------------------------------");
						System.err.println("DAT");
						System.out.println("------------------------------------------------------");
						FicheroDAT.komprobatu(Libros.get(i));
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Altuera")) {
				
				String laburAL = Libros.get(i).getAltuera().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getAltuera()) || pat.equals(laburAL))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
						Thread.sleep(1000);
						System.out.println("------------------------------------------------------");
						System.err.println("DAT");
						System.out.println("------------------------------------------------------");
						FicheroDAT.komprobatu(Libros.get(i));
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Oharrak")) {
				
				String laburOH = Libros.get(i).getOharrak().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getOharrak()) || pat.equals(laburOH))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
						Thread.sleep(1000);
						System.out.println("------------------------------------------------------");
						System.err.println("DAT");
						System.out.println("------------------------------------------------------");
						FicheroDAT.komprobatu(Libros.get(i));
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("ISBN")) {
				
				String laburIS = Libros.get(i).getISBN().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getISBN()) || pat.equals(laburIS))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
						Thread.sleep(1000);
						System.out.println("------------------------------------------------------");
						System.err.println("DAT");
						System.out.println("------------------------------------------------------");
						FicheroDAT.komprobatu(Libros.get(i));
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			} if(aukeratua.equals("Gaia")) {
				
				String laburG = Libros.get(i).getGaiak().substring(0,patam);
				
				if(pat.equals(Libros.get(i).getGaiak()) || pat.equals(laburG))
					try {
						FicheroDOM.komprobatu(Libros.get(i));
						Thread.sleep(1000);
						System.out.println("------------------------------------------------------");
						System.err.println("DAT");
						System.out.println("------------------------------------------------------");
						FicheroDAT.komprobatu(Libros.get(i));
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					} 
			}
		}
		Thread.sleep(1000);
		FicheroTXT.bilatuTXT(pat);
	}
} 