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

import javax.swing.JOptionPane;

import main.Liburua;

public class LeerFichero {

	public static void irakurri() throws IOException, ClassNotFoundException {
		main.Liburua liburua; 
		File fitxeroa = new File("Liburu.dat");
		FileInputStream fitxategia;
		ObjectInputStream dataIS;
		try {
			fitxategia = new FileInputStream(fitxeroa); 
			dataIS = new ObjectInputStream(fitxategia);
			while (fitxategia.getChannel().position() < fitxategia.getChannel().size()) {
				liburua = (main.Liburua) dataIS.readObject();
				System.out.printf("Izenburua: %s, Argitaletxea: %s, Orrialdeak: %s, Altuera: %s, Oharrak: %s, ISBN: %s, Gaiak: %s", liburua.getIzenburua(),liburua.getArgitaletxea(), liburua.getOrrialdeak(),liburua.getAltuera(), liburua.getOharrak(), liburua.getISBN(), liburua.getGaiak());
			}
			dataIS.close();
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
		}
		
	}
	
	public static void datuakSartu() {
		File fitxeroa = new File("Liburu.dat");
		FileOutputStream fitxategia;
		ObjectOutputStream dataIS;
		try {
			fitxategia = new FileOutputStream(fitxeroa,false);
			dataIS= new ObjectOutputStream(fitxategia);
			/*for (int i=0; i<arraya.size(); i++) {  
				dataIS.writeObject(arraya.get(i));  
			}*/
			Liburua l = new Liburua("Miss Marte", "Alfaguara", "245", "24", "Castellano", "9788420454337", "Novela");
			dataIS.writeObject(l);
			fitxategia.close(); 
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Fitxeroa ezin da aurkitu"); 
		} catch (IOException e1) { 
			JOptionPane.showMessageDialog(null, "Errorea fitxeroa idazterakoan");
			e1.printStackTrace();
		}
	}
}
