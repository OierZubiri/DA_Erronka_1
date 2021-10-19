package fitxeroDat;

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

import main.Liburua;

public class LeerFichero {

	public static void irakurri() throws IOException, ClassNotFoundException {
		ArrayList<Liburua> libros = new ArrayList<>(); 
		main.Liburua liburua; 
		File fitxeroa = new File("Liburu.dat");
		FileInputStream fitxategia;
		ObjectInputStream dataIS;
		try {
			fitxategia = new FileInputStream(fitxeroa); 
			dataIS = new ObjectInputStream(fitxategia);
			while (fitxategia.getChannel().position() < fitxategia.getChannel().size()) {
				liburua = (main.Liburua) dataIS.readObject();
				System.out.printf("Izenburua: %s\nArgitaletxea: %s\nOrrialdeak: %s\nAltuera: %s\nOharrak: %s\nISBN: %s\nGaiak: %s\n", liburua.getIzenburua(),liburua.getArgitaletxea(), liburua.getOrrialdeak(),liburua.getAltuera(), liburua.getOharrak(), liburua.getISBN(), liburua.getGaiak());
				libros.add(liburua);
			}
			dataIS.close();
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
		}
		main.app.setLibros(libros);
	}

	public static void datuakSartu() {  
		ArrayList<Liburua> Libros = main.app.getLibros();
		File fitxeroa = new File("Liburu.dat");
		FileOutputStream fitxategia;
		ObjectOutputStream dataIS;
		try {
			fitxategia = new FileOutputStream(fitxeroa,false);
			dataIS= new ObjectOutputStream(fitxategia);
			for (int i=0; i<Libros.size(); i++) {  
				dataIS.writeObject(Libros.get(i));  
			}
			fitxategia.close(); 
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Fitxeroa ezin da aurkitu"); 
		} catch (IOException e1) { 
			JOptionPane.showMessageDialog(null, "Errorea fitxeroa idazterakoan");
			e1.printStackTrace();
		}
	}
}