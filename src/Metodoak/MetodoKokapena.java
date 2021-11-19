package Metodoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetodoKokapena {

	private static String ruta;

	// __________________________________________________________________________________________________________________//
	
	public static boolean fitxeroAukeratu(Scanner sc) throws IOException {
		boolean aukeraOna = false;
		Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaFitxeroa);
		String zbk = "";
		do {
			System.out.println("Aukeratu mugitu nahi duzun fitxategia\n" + "1 --> Liburuak.txt\n"
					+ "2 --> Liburuak.dat\n" + "3 --> Liburuak.xml");
			zbk = sc.nextLine();
			Matcher m = p.matcher(zbk);
			if (m.matches())
				aukeraOna = true;
		} while (!aukeraOna);
		kokapenaAldatu(sc, zbk);
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean kokapenaAldatu(Scanner sc, String zbk) throws IOException {

		switch (Integer.parseInt(zbk)) {
		case 1:
			bilatuFitxeroa("Liburuak.txt");
			fitxeroak(sc, "/Liburuak.txt");
			break;
		case 2:
			bilatuFitxeroa("Liburuak.xml");
			fitxeroak(sc, "/Liburuak.xml");
			break;
		case 3:
			bilatuFitxeroa("Liburuak.dat");
			fitxeroak(sc, "/Liburuak.dat");
			break;
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean fitxeroak(Scanner sc, String aukera) throws IOException {
		boolean ondo = false;

		do {
			System.out.println("Sartu kokapen berria");
			String newDirectoryName = sc.nextLine();
			String testua = "";
			File dirFile = null;
			dirFile = new File(newDirectoryName);

			if (!dirFile.isDirectory()) {
				System.out.println("Ez da ruta bat");
				ondo = false;
			} else if (!dirFile.exists()) {
				System.out.println("Ruta ez da existitzen");
				ondo = false;
			} else {

				try {
					File fic = new File(ruta+aukera);
					BufferedReader fichero = new BufferedReader(new FileReader(fic));
					String linea;
					while ((linea = fichero.readLine()) != null) {
						testua = testua + linea + " \n";
					}
					fichero.close();

					String sPath = File.separator + newDirectoryName + File.separator + aukera;

					BufferedWriter fichero1 = new BufferedWriter(new FileWriter(sPath));
					fichero1.write(testua);
					fichero1.close();
					fic.delete();
					ondo = true;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} while (!ondo);
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean bilatuFitxeroa(String name) {

		findFile(name, new File(System.getProperty("user.home") + "/desktop"));

		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean findFile(String name, File file) {

		File[] list = file.listFiles();
		if (list != null)
			for (File fil : list) {
				if (fil.isDirectory()) {
					findFile(name, fil);
				} else if (name.equalsIgnoreCase(fil.getName())) {
					guardarRuta(fil.getParentFile().toString());
				}
			}
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean guardarRuta(String rutaDefinitiva) {
		ruta = rutaDefinitiva;
		return true;
	}
}
