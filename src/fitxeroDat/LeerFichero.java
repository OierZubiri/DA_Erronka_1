package fitxeroDat;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

import fitxeroDat.Liburua;

public class LeerFichero {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Liburua liburua; 
		 File fichero = new File("FichPersona.dat");
		 FileInputStream fi = new FileInputStream(fichero);
		 ObjectInputStream dataIS = new ObjectInputStream(fi);
		 int i = 1;
		 try {
		 while (fi.getChannel().position() < fi.getChannel().size()) { 
			 liburua = (Liburua) dataIS.readObject(); 
		 System.out.print(i + "=>");
		 i++;
		 System.out.printf("Izenburua: %s, Argitaletxea: %d %n, Orrialdeak: %s, Altuera: %s, Oharrak: %s, ISBN: %s, Gaiak: %s", liburua.getIzenburua(),liburua.getArgitaletxea(), liburua.getOrrialdeak(),liburua.getAltuera(), liburua.getOharrak(), liburua.getISBN(), liburua.getGaiak());
		 }
		 } catch (EOFException eo) {
		 System.out.println("FIN DE LECTURA.");
		 } catch (StreamCorruptedException x) {
		 }
		 dataIS.close();

	}

}
