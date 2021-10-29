package Ficheros;

import java.io.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

			while ((linea = fichero.readLine()) != null) {
				if(hartu(linea).equals("")) {
					System.out.print(linea + " \n");
				}else {
					System.out.println(hartu(linea)+"0");
				}
			}
				

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
	
	public static String hartu(String l) {
		int split=0;
		Pattern pat = Pattern.compile(Metodoak.MetodoakPatroiak.izena);
		Pattern pat1 = Pattern.compile(Metodoak.MetodoakPatroiak.texto);
		Pattern pat2 = Pattern.compile(Metodoak.MetodoakPatroiak.ISBN);
		Pattern pat3 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
		
		if(l.contains("Izenburua:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "Izenburua: ";
				}
		 }
		
		if(l.contains("Argitaletxea:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "Argitaletxea: ";
				}
		 }
		
		if(l.contains("Orrialdeak:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat3.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "Orrialdeak: ";
				}
		 }
		
		if(l.contains("Altuera:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat3.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "Altuera: ";
				}
		 }
		
		if(l.contains("Oharrak:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat1.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "Oharrak: ";
				}
		 }
		
		if(l.contains("ISBN:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat2.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "ISBN: ";
				}
		 }
		
		if(l.contains("Gaiak:")) {
			 split = l.indexOf(":");
			 String s = l.substring(split+1);
			 Matcher mat = pat3.matcher(s);
			 if(mat.matches()==true) {
					return "";
				}else {
					return "Gaiak: ";
				}
		 }
		return "";
	}

}