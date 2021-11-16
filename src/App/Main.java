package App;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import Metodoak.Liburua;
import Metodoak.MetodoakPatroiak;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, ParserConfigurationException,
			SAXException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		boolean zenbkiOna = false;
		String zbk;

		do {
			Pattern p = Pattern.compile(MetodoakPatroiak.zenbakiaMenua);
			do {
				zenbkiOna = true;
				System.out.println("\n1 --> Gehitu\n" + "2 --> Irakurri\n" + "3 --> Liburu bilatu\n" + "4 --> Atera");
				zbk = sc.nextLine();
				Matcher m = p.matcher(zbk);
				if (m.matches())
					zenbkiOna = false;
			} while (zenbkiOna);

			switch (Integer.parseInt(zbk)) {

			case 1:
				Liburua l1 = Metodoak.MetodoLiburuak.gehituLiburu(sc);
				Metodoak.MetodoLiburuak.sartutakoLiburua(l1);
				Metodoak.MetodoLiburuak.Libros.add(l1);
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
				Metodoak.MetodoakBilatu.bilatuLiburua(sc);
				zenbkiOna = true;
				break;
			case 4:
				zenbkiOna = false;
				break;
			default:
				System.out.println("Sartu 1 eta 4 artean egin behar da");
			}
		} while (zenbkiOna);
	}
}