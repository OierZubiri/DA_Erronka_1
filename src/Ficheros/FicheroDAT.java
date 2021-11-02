package Ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Metodoak.Liburua;

public class FicheroDAT {

	// __________________________________________________________________________________________________________________//

	public static boolean sartuDAT() {
		ArrayList<Liburua> Libros = Metodoak.MetodoLiburuak.getLibros();
		File fitxeroa = new File("./datuak/Liburuak.dat");
		FileOutputStream fitxategia;
		ObjectOutputStream dataIS;

		try {
			fitxategia = new FileOutputStream(fitxeroa);
			dataIS = new ObjectOutputStream(fitxategia);

			for (int i = 0; i < Libros.size(); i++) {
				dataIS.writeObject(Libros.get(i));
			}

			fitxategia.close();
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Fitxeroa ezin da aurkitu");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Errorea fitxeroa idazterakoan");
			e1.printStackTrace();
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean irakurriDAT() throws IOException, ClassNotFoundException, InterruptedException {
		ArrayList<Liburua> libros = new ArrayList<>();
		Metodoak.Liburua liburua;
		File fitxeroa = new File("./datuak/Liburuak.dat");
		FileInputStream fitxategia;
		ObjectInputStream dataIS;
		
		System.out.println("\n" + "------------------------------------------------------");
		Thread.sleep(100);
		System.err.println("DAT Fitxategia");
		
		try {
			fitxategia = new FileInputStream(fitxeroa);
			dataIS = new ObjectInputStream(fitxategia);
			while (fitxategia.getChannel().position() < fitxategia.getChannel().size()) {
				System.out.println("------------------------------------------------------");
				liburua = (Metodoak.Liburua) dataIS.readObject();
				komprobatu(liburua);
				libros.add(liburua);
				
			}
			dataIS.close();
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
		}
		Metodoak.MetodoLiburuak.setLibros(libros);
		Thread.sleep(1000);
		return true;
	}
	
	// __________________________________________________________________________________________________________________//

	public static String komprobatu(Liburua lib) {
		Pattern pat = Pattern.compile(Metodoak.MetodoakPatroiak.izena);
		Pattern pat1 = Pattern.compile(Metodoak.MetodoakPatroiak.texto);
		Pattern pat2 = Pattern.compile(Metodoak.MetodoakPatroiak.ISBN);
		Pattern pat3 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
		
		
		Matcher mat = pat.matcher(lib.getIzenburua());
		if(mat.matches()==true) {
			System.out.println("Izenburua: " + lib.getIzenburua());
		}else {
			lib.setIzenburua("Datu desegokia.");
			System.out.println("Izenburua: " +  lib.getIzenburua());
		}
		
		Matcher mat1 = pat.matcher(lib.getArgitaletxea());
		if(mat1.matches()==true) {
			System.out.println("Argitaletxea: " + lib.getArgitaletxea());
		}else {
			lib.setArgitaletxea("Datu desegokia.");
			System.out.println("Argitaletxea:"  +  lib.getArgitaletxea());
		}
		
		Matcher mat2 = pat3.matcher(lib.getOrrialdeak());
		if(mat2.matches()==true) {
			System.out.println("Orrialdeak: " + lib.getOrrialdeak());
		}else {
			lib.setOrrialdeak("Datu desegokia.");
			System.out.println("Orrialdeak: " + lib.getOrrialdeak());
		}
		
		Matcher mat3 = pat3.matcher(lib.getAltuera());
		if(mat3.matches()==true) {
			System.out.println("Altuera: " + lib.getAltuera());
		}else {
			lib.setAltuera("Datu desegokia.");
			System.out.println("Altuera: "+ lib.getAltuera());
		}
		
		Matcher mat4 = pat1.matcher(lib.getOharrak());
		if(mat4.matches()==true) {
			System.out.println("Oharrak: " + lib.getOharrak());
		}else {
			lib.setOharrak("Datu desegokia.");
			System.out.println("Oharrak: " + lib.getOharrak());
		}
		
		Matcher mat5 = pat2.matcher(lib.getISBN());
		if(mat5.matches()==true) {
			System.out.println("ISBN: " + lib.getISBN());
		}else {
			lib.setISBN("Datu desegokia.");
			System.out.println("ISBN: "+lib.getISBN());
		}
		
		Matcher mat6 = pat3.matcher(lib.getGaiak());
		if(mat6.matches()==true) {
			System.out.println("Gaiak: " + lib.getGaiak());
		}else {
			lib.setGaiak("Datu desegokia.");
			System.out.println("Gaiak: "+lib.getGaiak());
		}
		return "";
	}

}