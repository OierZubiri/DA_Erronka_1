package Metodoak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Ficheros.FicheroDAT;
import Ficheros.FicheroDOM;

public class MetodoakBilatu {

	// __________________________________________________________________________________________________________________//

	public static boolean bilatuLiburua(Scanner sc) throws InterruptedException {
		boolean zenbkiOna = false;
		String zbk;

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaBilatu);
			do {
				zenbkiOna = true;
				System.out.println("Zerekin bilatu nahi duzu?\n" + "1--> Izenburua\n" + "2--> Argitaletxea\n"
						+ "3--> Orrialdeak\n" + "4--> Altuera\n" + "5--> Oharrak\n" + "6--> ISBN\n" + "7--> Gaia");
				zbk = sc.nextLine();
				Matcher m = p.matcher(zbk);
				if (m.matches())
					zenbkiOna = false;
			} while (zenbkiOna);

			switch (Integer.parseInt(zbk)) {

			case 1:
				aukera("Izenburua", 1, sc);
				zenbkiOna = false;
				break;
			case 2:
				aukera("Argitaletxea", 2, sc);
				zenbkiOna = false;
				break;
			case 3:
				aukera("Orrialdeak", 3, sc);
				zenbkiOna = false;
				break;
			case 4:
				aukera("Altuera", 4, sc);
				zenbkiOna = false;
				break;
			case 5:
				aukera("Oharrak", 5, sc);
				zenbkiOna = false;
				break;
			case 6:
				aukera("ISBN", 6, sc);
				zenbkiOna = false;
				break;
			case 7:
				aukera("Gaia", 7, sc);
				zenbkiOna = false;
				break;
			default:
				System.out.println("Sartu 1 eta 7 artean egon behar da");
			}
		} while (zenbkiOna);

		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean aukera(String aukeratua, int lineaElegida, Scanner sc) throws InterruptedException {
		String aukera = "";
		System.out.println("Esan " + aukeratua + ":");
		aukera = sc.nextLine();
		if (aukera.length() != 0) {
			bilatuDOM(aukeratua, aukera);
			Thread.sleep(100);
			bilatuDAT(aukeratua, aukera);
			Thread.sleep(100);
			bilatuTXT(lineaElegida, aukera);
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean bilatuDOM(String lineaElegida, String aukera) throws InterruptedException {
		for (int i = 0; i < Metodoak.MetodoLiburuak.Libros.size(); i++) {
			if (lineaElegida.equals("Izenburua")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getIzenburua())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getIzenburua().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
			if (lineaElegida.equals("Argitaletxea")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getArgitaletxea())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getArgitaletxea().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
			if (lineaElegida.equals("Orrialdeak")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getOrrialdeak())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getOrrialdeak().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
			if (lineaElegida.equals("Altuera")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getAltuera())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getAltuera().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
			if (lineaElegida.equals("Oharrak")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getOharrak())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getOharrak().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
			if (lineaElegida.equals("ISBN")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getISBN())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getISBN().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
			if (lineaElegida.equals("Gaia")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getGaiak())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getGaiak().contains(aukera)) {
					marraztuLiburuaDOM(i);
				}
			}
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean bilatuDAT(String lineaElegida, String aukera) throws InterruptedException {
		for (int i = 0; i < Metodoak.MetodoLiburuak.Libros.size(); i++) {
			if (lineaElegida.equals("Izenburua")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getIzenburua())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getIzenburua().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
			if (lineaElegida.equals("Argitaletxea")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getArgitaletxea())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getArgitaletxea().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
			if (lineaElegida.equals("Orrialdeak")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getOrrialdeak())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getOrrialdeak().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
			if (lineaElegida.equals("Altuera")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getAltuera())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getAltuera().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
			if (lineaElegida.equals("Oharrak")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getOharrak())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getOharrak().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
			if (lineaElegida.equals("ISBN")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getISBN())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getISBN().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
			if (lineaElegida.equals("Gaia")) {
				if (aukera.equals(Metodoak.MetodoLiburuak.Libros.get(i).getGaiak())
						|| Metodoak.MetodoLiburuak.Libros.get(i).getGaiak().contains(aukera)) {
					marraztuLiburuaDAT(i);
				}
			}
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean bilatuTXT(int lineaElegida, String aukera) throws InterruptedException {
		try {
			File fic = new File("./datuak/Liburuak.txt");
			BufferedReader fichero = new BufferedReader(new FileReader(fic));
			String linea;

			int zbk = 0;
			boolean egokia = false;
			String texto = "";

			while ((linea = fichero.readLine()) != null) {
				if (Ficheros.FicheroTXT.komprobatu(linea).equals("")) {
					texto += linea + " \n";
					zbk++;

					if (!linea.contains("-")) {
						String[] parts = linea.split(":");
						String part = parts[1];

						if (part.contains(aukera) && lineaElegida == zbk - 1) {
							egokia = true;
						}

						if (zbk == 8 && egokia == true) {
							System.out.println("\n" + "------------------------------------------------------");
							Thread.sleep(100);
							System.err.println("Bilatzailea TXT");
							Thread.sleep(100);
							System.out.println(texto);
						}

						if (zbk == 8) {
							texto = "";
							egokia = false;
							zbk = 0;
						}
					}
				}
			}

			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean marraztuLiburuaDOM(int i) throws InterruptedException {
		System.out.println("\n" + "------------------------------------------------------");
		Thread.sleep(100);
		System.err.println("Bilatzailea XML");
		Thread.sleep(100);
		System.out.println("------------------------------------------------------");
		FicheroDOM.komprobatu(Metodoak.MetodoLiburuak.Libros.get(i));
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean marraztuLiburuaDAT(int i) throws InterruptedException {
		System.out.println("\n" + "------------------------------------------------------");
		Thread.sleep(100);
		System.err.println("Bilatzailea DAT");
		Thread.sleep(100);
		System.out.println("------------------------------------------------------");
		FicheroDAT.komprobatu(Metodoak.MetodoLiburuak.Libros.get(i));
		return true;
	}
}