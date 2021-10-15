package fitxeroDOM;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class FitxategiDOM {
	
	public static void DOM() {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			MiHandler miHandler = new MiHandler();
			SAXParser parser = factory.newSAXParser();
			parser.parse("Liburuak.xml", miHandler);
			ArrayList<Liburua> Libros = miHandler.obtenerLiburu();

			for (Liburua lib : Libros) {
				System.out.println("------------------------------------------------------");
				System.out.println("Izenburua: " + lib.getIzenburua());
				System.out.println("Argitaletxea: " + lib.getArgitaletxea());
				System.out.println("Orrialdeak: " + lib.getOrrialdeak());
				System.out.println("Altuera: " + lib.getAltuera());
				System.out.println("Oharrak: " + lib.getOharrak());
				System.out.println("ISBN: " + lib.getISBN());
				System.out.println("Gaiak: " + lib.getGaiak());
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
