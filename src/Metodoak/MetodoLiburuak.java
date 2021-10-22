package Metodoak;

import java.util.ArrayList;
import java.util.Scanner;

public class MetodoLiburuak {

	//***************************************************************************************************************************//
	
		public static void ArgumentuaHutsik(String testua) throws ArgumentuaHutsik {
			if (testua.length() == 0)
				throw new ArgumentuaHutsik();
		}

		//***************************************************************************************************************************//

		public static void ZenbakiaDa1(String testua) throws ZenbakiaDa1 {
			try {
				Integer.parseInt(testua);
			} catch (NumberFormatException e) {
				throw new ZenbakiaDa1();
			}
		}
	
	public static ArrayList<Liburua> Libros = new ArrayList<>();
	
	//***************************************************************************************************************************//
	
		public static ArrayList<Liburua> getLibros() {
			return Libros;
		}

		//***************************************************************************************************************************//

		public static boolean setLibros(ArrayList<Liburua> libros) {
			Libros = libros;
			return true;
		} 
	
		//***************************************************************************************************************************//

		public static boolean sartutakoLiburua(Liburua l1) {
			
			System.out.println("\n" + "----------------SARTUTAKO LIBURUA---------------------");
			System.out.println(l1.toString());
			System.out.println("------------------------------------------------------");
			
			return true;
		}
		
		//***************************************************************************************************************************//

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
