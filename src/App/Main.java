package App;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import Metodoak.Liburua;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, ParserConfigurationException,
			SAXException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		boolean zenbkiOna = false;
		int zbk = 0;

		do {
			do {
				System.out.println("1 --> Gehitu\n" + "2 --> Irakurri\n" + "3 --> Atera");
				zbk = Metodoak.Metodoak.zenbakiaDa(sc.nextLine());
			} while (zbk == -1);

			switch (zbk) {

			case 1:
				Liburua l1 = Metodoak.Metodoak.gehituLiburu(sc);
				Metodoak.Metodoak.Libros.add(l1);
				Ficheros.FicheroDOM.sartuDOM(l1);
				Ficheros.FicheroDAT.sartuDAT();
				Ficheros.FicheroTXT.sartuTXT();
				zenbkiOna = true;
				break;
			case 2:
				Ficheros.FicheroDOM.irakurriDOM();			
				Ficheros.FicheroTXT.irakurriTXT();			
				Ficheros.FicheroDAT.irakurriDAT();
				zenbkiOna = true;
				break;
			case 3:
				zenbkiOna = false;
				break;
			}
		} while (zenbkiOna);
	}
}