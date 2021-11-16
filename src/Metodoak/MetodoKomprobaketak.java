package Metodoak;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetodoKomprobaketak {

	// __________________________________________________________________________________________________________________//

		public static String izenburua(boolean ondo, Scanner sc) {
			String izenburua;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.izena);
				System.out.println("Sartu izenburua");
				izenburua = sc.nextLine();
				Matcher m = p.matcher(izenburua);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return izenburua;
		}

		// __________________________________________________________________________________________________________________//

		public static String argitaletxea(boolean ondo, Scanner sc) {
			String argitaletxea;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.izena);
				System.out.println("Sartu argitaletxea");
				argitaletxea = sc.nextLine();
				Matcher m = p.matcher(argitaletxea);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return argitaletxea;
		}

		// __________________________________________________________________________________________________________________//

		public static String orrialdeak(boolean ondo, Scanner sc) {
			String orrialdeak;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.zenbakia);
				System.out.println("Sartu orrialdeak");
				orrialdeak = sc.nextLine();
				Matcher m = p.matcher(orrialdeak);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return orrialdeak;
		}

		// __________________________________________________________________________________________________________________//

		public static String altuera(boolean ondo, Scanner sc) {
			String altuera;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.zenbakia);
				System.out.println("Sartu altuera");
				altuera = sc.nextLine();
				Matcher m = p.matcher(altuera);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return altuera;
		}

		// __________________________________________________________________________________________________________________//

		public static String oharrak(boolean ondo, Scanner sc) {
			String oharrak;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.texto);
				System.out.println("Sartu oharrak");
				oharrak = sc.nextLine();
				Matcher m = p.matcher(oharrak);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return oharrak;
		}

		// __________________________________________________________________________________________________________________//

		public static String ISBN(boolean ondo, Scanner sc) {
			String ISBN;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.ISBN);
				System.out.println("Sartu ISBN");
				ISBN = sc.nextLine();
				Matcher m = p.matcher(ISBN);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return ISBN;
		}

		// __________________________________________________________________________________________________________________//

		public static String gaiak(boolean ondo, Scanner sc) {
			String gaiak;
			do {
				Pattern p = Pattern.compile(MetodoakPatroiak.izena);
				System.out.println("Sartu gaiak");
				gaiak = sc.nextLine();
				Matcher m = p.matcher(gaiak);
				if (m.matches())
					ondo = true;
			} while (!ondo);
			return gaiak;
		}
	
}
