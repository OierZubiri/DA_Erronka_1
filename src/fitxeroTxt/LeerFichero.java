package fitxeroTxt;

import java.io.*; 
import java.util.ArrayList;
 
import main.Liburua;
public class LeerFichero {

	public static void irakurri() { 
		ArrayList<Liburua> libros = new ArrayList<>(); 
		main.Liburua liburua; 
		try{
			File fic = new File("Libros.txt");
			BufferedReader fichero = new BufferedReader(new FileReader(fic));
			String linea;
			while((linea = fichero.readLine())!=null)
				System.out.print(linea+" \n");
			fichero.close();
		}
		catch (FileNotFoundException fn){
			System.out.println("No se encuentra el fichero");}
		catch (IOException io) {
			System.out.println("Error de E/S ");
		}
		main.app.setLibros(libros);
	}

	public static void idatzi() {
		ArrayList<Liburua> Libros = main.app.getLibros();
		for (int i=0; i<Libros.size(); i++){
			System.err.println(Libros.get(i).toString());  
		}
		try{
			BufferedWriter fichero = new BufferedWriter(new FileWriter("Libros.txt", false));
			for (int i=0; i<Libros.size(); i++){
				fichero.write(Libros.get(i).toString()); 
				fichero.write("**********************");
			}
			fichero.close();
		}
		catch (FileNotFoundException fn ){
			System.out.println("No se encuentra el fichero");}
		catch (IOException io) {
			System.out.println("Error de E/S ");
		}
	}
}