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
				System.out.printf(
						"Izenburua: %s\nArgitaletxea: %s\nOrrialdeak: %s\nAltuera: %s\nOharrak: %s\nISBN: %s\nGaiak: %s\n",
						liburua.getIzenburua(), liburua.getArgitaletxea(), liburua.getOrrialdeak(),
						liburua.getAltuera(), liburua.getOharrak(), liburua.getISBN(), liburua.getGaiak());
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

}