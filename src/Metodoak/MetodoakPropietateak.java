package Metodoak;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Scanner;

public class MetodoakPropietateak {

	// __________________________________________________________________________________________________________________//

	public static boolean fitzpropietateak(Scanner sc) throws IOException {
		boolean ondo = true;
		do {
			System.out.println("Ze propietate ikusi nahi duzu:");
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
				MetodoKokapena.fitxeroAukeratu(sc);
				break;
			default:
				System.out.println("1-etik 3-ra sartu behar duzu");
				ondo = false;
			}
		} while (ondo == false);
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean baimenak(Scanner sc) {
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
		} while (ondo == false);
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean tamaina() {
		File fic = new File("./datuak/Liburuak.txt");
		File fic1 = new File("./datuak/Liburuak.xml");
		File fic2 = new File("./datuak/Liburuak.dat");

		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("TXT-ren tamaina " + fic.length() + " byte dira");
		System.out.println("XML-ren tamaina " + fic1.length() + " byte dira");
		System.out.println("DAT-ren tamaina " + fic2.length() + " byte dira");
		System.out.println("--------------------------------------------------------------------------------------");
		return true;
	}

	// __________________________________________________________________________________________________________________//
	
	public static boolean jabea() throws IOException {

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
		
		return true;
	}
}
