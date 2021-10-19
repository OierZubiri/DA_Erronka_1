package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import fitxeroDOM.MiHandler;

@SuppressWarnings("serial")
class ArgumentuaHutsik extends RuntimeException {
	public ArgumentuaHutsik() {
	};
}

@SuppressWarnings("serial")
class ZenbakiaDa1 extends RuntimeException {
	public ZenbakiaDa1() {
	};
}

public class app {

	static MiHandler miHandler = new MiHandler();
	static ArrayList<Liburua> Libros = miHandler.obtenerLiburu();

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IOException,
			ParserConfigurationException, SAXException {
		Scanner sc = new Scanner(System.in);
		int zbk = 0;
		do {
			do {
				System.out.println("1 --> Gehitu\n" + "2 --> Irakurri");
				zbk = zenbakiaDa(sc.nextLine());
			} while (zbk == -1);

			switch (zbk) {
			case 1:
				Liburua l1 = gehituLiburu(sc);
				Libros.add(l1);
				fitxeroDOM.FitxategiDOM.DOMidatzi(l1);
				break;
			case 2:
				System.err.println("XML Fitxategia");
				fitxeroDOM.FitxategiDOM.DOMirakurri();
				Thread.sleep(2000);
				System.err.println("TXT Fitxategia");
				fitxeroTxt.LeerFichero.leertxt();
				Thread.sleep(2000);
				fitxeroDat.LeerFichero.irakurri();
				Thread.sleep(2000);
				break;
			}
		} while (zbk != 0);
	}

	public static int zenbakiaDa(String zbks) {
		int zbk = 0;
		try {
			zbk = Integer.parseInt(zbks);
		} catch (Exception e) {
			System.out.println("Ez duzu zenbaki bat sartu");
			zbk = -1;
		}
		return zbk;
	}

	public static void ArgumentuaHutsik(String testua) throws ArgumentuaHutsik {
		if (testua.length() == 0)
			throw new ArgumentuaHutsik();
	}

	public static void ZenbakiaDa1(String testua) throws ZenbakiaDa1 {
		try {
			Integer.parseInt(testua);
		} catch (NumberFormatException e) {
			throw new ZenbakiaDa1();
		}
	}

	public static Liburua gehituLiburu(Scanner sc) {
		boolean ondo = false;

		String izenburua = null, argitaletxea = null, orrialdeak = null, altuera = null, oharrak = null, ISBN = null,
				gaiak = null;

		do {
			try {
				System.out.println("Sartu izenburua");
				izenburua = sc.nextLine();
				ArgumentuaHutsik(izenburua);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			}
		} while (!ondo);

		do {
			try {
				System.out.println("Sartu argitaletxea");
				argitaletxea = sc.nextLine();
				ArgumentuaHutsik(argitaletxea);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			}
		} while (!ondo);

		do {
			try {
				System.out.println("Sartu orrialdeak");
				orrialdeak = sc.nextLine();
				ArgumentuaHutsik(orrialdeak);
				ZenbakiaDa1(orrialdeak);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			} catch (ZenbakiaDa1 z) {
				ondo = false;
				System.out.println("Ez duzu zenbaki bat sartu");
			}
		} while (!ondo);

		do {
			try {
				System.out.println("Sartu altuera");
				altuera = sc.nextLine();
				ArgumentuaHutsik(altuera);
				ZenbakiaDa1(altuera);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			} catch (ZenbakiaDa1 z) {
				ondo = false;
				System.out.println("Ez duzu zenbaki bat sartu");
			}
		} while (!ondo);

		do {
			try {
				System.out.println("Sartu oharrak");
				oharrak = sc.nextLine();
				ArgumentuaHutsik(oharrak);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			}
		} while (!ondo);

		do {
			try {
				System.out.println("Sartu ISBN");
				ISBN = sc.nextLine();
				ArgumentuaHutsik(ISBN);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			}
		} while (!ondo);

		do {
			try {
				System.out.println("Sartu gaiak");
				gaiak = sc.nextLine();
				ArgumentuaHutsik(gaiak);
				ondo = true;
			} catch (ArgumentuaHutsik a) {
				ondo = false;
				System.out.println("Ez duzu ezer sartu");
			}
		} while (!ondo);

		return new Liburua(izenburua, argitaletxea, orrialdeak, altuera, oharrak, ISBN, gaiak);
	}
}