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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetodoakPropietateak {

	// __________________________________________________________________________________________________________________//

	public static boolean fitzpropietateak(Scanner sc) throws IOException {
		boolean zenbkiOna = false;




		do {	
			String zbks ="";
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaFitxeroa);
			do {
				zenbkiOna = true;
				System.out.println("Ze propietate ikusi nahi duzu:");
				System.out.println("1- Fitzeroaren tamaina");
				System.out.println("2- Fitzeroaren baimenak aldatu");
				System.out.println("3- Fitzeroaren jabea aldatu");
				System.out.println("4- Kokapena aldatu");
				zbks = sc.nextLine();
				Matcher m = p.matcher(zbks);
				if(m.matches())
					zenbkiOna = false;
			} while (zenbkiOna);
			switch (Integer.parseInt(zbks)) {

			case 1:
				tamaina();
				break;
			case 2:
				baimenak(sc);
				break;
			case 3:
				jabea(sc);
				break;
			case 4:
				MetodoKokapena.fitxeroAukeratu(sc);
				break;
			default:
				System.out.println("1-etik 4-ra sartu behar duzu");
				zenbkiOna = true;
			}
		} while (zenbkiOna);
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean baimenak(Scanner sc) {
		boolean ondo = true;

		MetodoakRuta.bilatuFitxeroa("Liburuak.txt");
		File fic = new File(MetodoakRuta.ruta+"/Liburuak.txt");

		MetodoakRuta.bilatuFitxeroa("Liburuak.xml");
		File fic1 = new File(MetodoakRuta.ruta+"/Liburuak.xml");

		MetodoakRuta.bilatuFitxeroa("Liburuak.dat");
		File fic2 = new File(MetodoakRuta.ruta+"/Liburuak.dat");

		boolean zenbkiOna = false;

		do {
			String zbks = "";
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaProp);
			do {
				zenbkiOna = true;
				System.out.println(" ");
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println("Fitzeroen baimenak aldatzeko:");
				System.out.println("1-Idatzi");
				System.out.println("2-Irakurri bakarrik"); 
				zbks = sc.nextLine();
				Matcher m = p.matcher(zbks);
				if(m.matches())
					zenbkiOna = false;
			} while (zenbkiOna);

			switch (Integer.parseInt(zbks)) {

			case 1:
				fic.setReadable(true);
				fic.setWritable(true);
				fic1.setReadable(true);
				fic1.setWritable(true);
				fic2.setReadable(true);
				fic2.setWritable(true);
				break;
			case 2:
				fic.setReadable(true);
				fic.setWritable(false);
				fic1.setReadable(true);
				fic1.setWritable(false);
				fic2.setReadable(true);
				fic2.setWritable(false);
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
		MetodoakRuta.bilatuFitxeroa("Liburuak.txt");
		File fic = new File(MetodoakRuta.ruta+"/Liburuak.txt");

		MetodoakRuta.bilatuFitxeroa("Liburuak.xml");
		File fic1 = new File(MetodoakRuta.ruta+"/Liburuak.xml");

		MetodoakRuta.bilatuFitxeroa("Liburuak.dat");
		File fic2 = new File(MetodoakRuta.ruta+"/Liburuak.dat");


		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("TXT-ren tamaina " + fic.length() + " byte dira");
		System.out.println("XML-ren tamaina " + fic1.length() + " byte dira");
		System.out.println("DAT-ren tamaina " + fic2.length() + " byte dira");
		System.out.println("--------------------------------------------------------------------------------------");
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean jabea(Scanner sc) throws IOException {
		String zbk = "";

		boolean aukeraOna = false;
		Pattern p1 = Pattern.compile(MetodoakPatroiak.zenbakiaFitxeroa);
		do {
			System.out.println("Aukeratu erabili nahi duzun fitxategia\n" + "1 --> Liburuak.txt\n"
					+ "2 --> Liburuak.xml\n" + "3 --> Liburuak.dat");
			zbk = sc.nextLine();
			Matcher m = p1.matcher(zbk);
			if (m.matches())
				aukeraOna = true;
		} while (!aukeraOna);

		switch (Integer.parseInt(zbk)) {
		case 1:
			MetodoakRuta.bilatuFitxeroa("Liburuak.txt"); 
			jabea1("/Liburuak.txt", sc);
			break;
		case 2:
			MetodoakRuta.bilatuFitxeroa("Liburuak.xml"); 
			jabea1("/Liburuak.xml", sc);
			break;
		case 3:
			MetodoakRuta.bilatuFitxeroa("Liburuak.dat"); 
			jabea1("/Liburuak.dat", sc);
			break;
		}
		return true;
	}
	
	public static boolean jabea1(String aukera, Scanner sc) throws IOException {
		boolean jabeona = false; 
		String jabea;
		System.out.println(MetodoakRuta.ruta);
		Path path = Paths.get(MetodoakRuta.ruta+aukera);

		System.out.println("-- Jabea zaharra --");
		UserPrincipal owner = Files.getOwner(path);
		System.out.println("Owner: " + owner);

		do {
			Pattern p = Pattern.compile(Metodoak.MetodoakPatroiak.texto);
			System.out.println("Sartu jabe berria:");
			jabea=sc.nextLine();
			Matcher m = p.matcher(jabea);
			if(m.matches()) {
				jabeona=true;
			}
		}while(jabeona==false);

		FileSystem fileSystem = path.getFileSystem();
		UserPrincipalLookupService service = fileSystem.getUserPrincipalLookupService();

		UserPrincipal userPrincipal = service.lookupPrincipalByName(jabea);
		System.out.println("Found UserPrincipal: " + userPrincipal);

		Files.setOwner(path, userPrincipal);

		System.out.println("-- Jabe berria --");
		owner = Files.getOwner(path);
		System.out.println("Jabea: " + owner.getName());
		return true;	
	}
}
