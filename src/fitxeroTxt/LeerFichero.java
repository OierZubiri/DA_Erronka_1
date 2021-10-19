package fitxeroTxt;

import java.io.*;
public class LeerFichero {
	public static void irakurri() {
		try{
			File fic = new File("Libros.txt");
			BufferedReader fichero = new BufferedReader(new FileReader(fic));

			String linea;
			while((linea = fichero.readLine())!=null)
				System.out.println(linea);
			fichero.close();
		}
		catch (FileNotFoundException fn){
			System.out.println("No se encuentra el fichero");}
		catch (IOException io) {
			System.out.println("Error de E/S ");
		}
	}
}
