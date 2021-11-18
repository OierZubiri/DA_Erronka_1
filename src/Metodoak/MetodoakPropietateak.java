package Metodoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetodoakPropietateak {

	// __________________________________________________________________________________________________________________//

	public static void fitzpropietateak(Scanner sc) throws IOException {
		boolean ondo = true;
		do {
			System.out.println("Ze propietate ikusi nahai duzu:");
			System.out.println("1- Fitzeroaren tamaina");
			System.out.println("2- Fitzeroaren baimenak aldatu");
			System.out.println("3- Fitzeroaren jabea aldatu");
			System.out.println("4- Kokapena aldatu");
			int aukera = sc.nextInt();

			switch (aukera) {

			case 1:
				tamaina();
				break;
			case 2:
				baimenak(sc);
				break;
			case 3:
				jabea();
				break;
			case 4:
				fitxeroAukeratu(sc);
				break;
			default:
				System.out.println("1-etik 3-ra sartu behar duzu");
				ondo = false;
			}
		} while (ondo == false);
	}

	public static void baimenak(Scanner sc) {
		boolean ondo = true;

		File fic = new File("./datuak/Liburuak.txt");
		File fic1 = new File("./datuak/Liburuak.xml");
		File fic2 = new File("./datuak/Liburuak.dat");

		do {
			System.out.println(" ");
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println("Fitzeroen baimenak aldatzeko:");
			System.out.println("1-Idatzi");
			System.out.println("2-Irakurri bakarrik");
			System.out.println("3-Ejetutatu ez");
			int aukera = sc.nextInt();

			switch (aukera) {

			case 1:
				fic.setReadable(true);
				fic.setWritable(true);
				fic.setExecutable(true);
				fic1.setReadable(true);
				fic1.setWritable(true);
				fic1.setExecutable(true);
				fic2.setReadable(true);
				fic2.setWritable(true);
				fic2.setExecutable(true);
				break;
			case 2:
				fic.setReadable(true);
				fic.setWritable(false);
				fic.setExecutable(true);
				fic1.setReadable(true);
				fic1.setWritable(false);
				fic1.setExecutable(true);
				fic2.setReadable(true);
				fic2.setWritable(false);
				fic2.setExecutable(true);
				break;
			case 3:
				fic.setReadable(false);
				fic.setWritable(false);
				fic.setExecutable(false);
				fic1.setReadable(false);
				fic1.setWritable(false);
				fic1.setExecutable(false);
				fic2.setReadable(false);
				fic2.setWritable(false);
				fic2.setExecutable(false);
				break;
			default:
				System.out.println("1-etik 3-ra sartu behar duzu");
				ondo = false;
			}
		} while (ondo = false);
	}

	public static void tamaina() {
		File fic = new File("./datuak/Liburuak.txt");
		File fic1 = new File("./datuak/Liburuak.xml");
		File fic2 = new File("./datuak/Liburuak.dat");

		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("TXT-ren tamaina " + fic.length() + " byte dira");
		System.out.println("XML-ren tamaina " + fic1.length() + " byte dira");
		System.out.println("DAT-ren tamaina " + fic2.length() + " byte dira");
		System.out.println("--------------------------------------------------------------------------------------");
	}

	public static void jabea() throws IOException {

		System.out.println();
		Path path = Paths.get("./datuak/Liburuak.txt");

		System.out.println("-- Jabea zaharra --");
		UserPrincipal owner = Files.getOwner(path);
		System.out.println("Owner: " + owner);

		System.out.println("-- lookup other user --");
		FileSystem fileSystem = path.getFileSystem();
		UserPrincipalLookupService service = fileSystem.getUserPrincipalLookupService();
		UserPrincipal userPrincipal = service.lookupPrincipalByName("asier");
		System.out.println("Found UserPrincipal: " + userPrincipal);

		// changing owner
		Files.setOwner(path, userPrincipal);

		System.out.println("-- Jabe berria --");
		owner = Files.getOwner(path);
		System.out.println("Owner: " + owner.getName());
	}

	public static void fitxeroAukeratu(Scanner sc) {
		boolean aukeraOna = false;
		Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaFitxeroa);
		String zbk = "";
		do {
			System.out.println("Aukeratu mugitu nahi duzun fitxategia\n" + "1 --> Liburuak.txt\n" + "2 --> Liburuak.dat\n" + "3 --> Liburuak.xml");
			zbk = sc.nextLine();
			Matcher m = p.matcher(zbk);
			if (m.matches())
				aukeraOna = true;
		} while (!aukeraOna);
		kokapenaAldatu(sc, zbk);
	}

	public static void kokapenaAldatu(Scanner sc, String zbk) {
		/*
		 * File file = new File("./datuak/Liburuak.xml"); String directoryName =
		 * file.getAbsoluteFile().toString(); System.out.println(directoryName);
		 */

		switch (Integer.parseInt(zbk)) {
		case 1:
			fitxeroak(sc, "Liburuak.txt");
			break;
		case 2:
			fitxeroak(sc, "Liburuak.dat");
			break;
		case 3:
			fitxeroak(sc, "Liburuak.xml");
			break;
		}
	}

	public static void fitxeroak(Scanner sc, String aukera) {
		boolean ondo = false;
		do {
			System.out.println("Sartu kokapen berria");
			String newDirectoryName = sc.nextLine();
			File dirFile = null;
			dirFile = new File(newDirectoryName);
			String testua = "";
			if (!dirFile.isDirectory()) {
				System.out.println("Ez da ruta bat");
				ondo = false;
			} else if (!dirFile.exists()) {
				System.out.println("Ruta ez existitzen");
				ondo = false;
			} else {
				try {
					File fic = new File("./datuak/" + aukera);
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
	}
}
