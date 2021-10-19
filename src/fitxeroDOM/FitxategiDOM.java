package fitxeroDOM;
import java.io.IOException;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class FitxategiDOM {
	
	public static void DOMidatzi() throws ParserConfigurationException, SAXException, IOException {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("Liburuak.xml");
			
			try {
				Element elementoRaiz = doc.getDocumentElement();

				Element cochesU = doc.createElement("CD");
				elementoRaiz.appendChild(cochesU);
				
				Element title = doc.createElement("TITLE");
				title.appendChild(doc.createTextNode("Empire Burlesque"));
				cochesU.appendChild(title);

				Element artist = doc.createElement("ARTIST");
				artist.appendChild(doc.createTextNode("Bob Dylan"));
				cochesU.appendChild(artist);
				
				Element country = doc.createElement("COUNTRY");
				country.appendChild(doc.createTextNode("EEUU"));
				cochesU.appendChild(country);
				
				Element nCoche1 = doc.createElement("COMPANY");
				nCoche1.appendChild(doc.createTextNode("Columbia"));
				cochesU.appendChild(nCoche1);
				
				Element nCoche2 = doc.createElement("PRICE");
				nCoche2.appendChild(doc.createTextNode("10.90"));
				cochesU.appendChild(nCoche2);
				
				Element nCoche3 = doc.createElement("YEAR");
				nCoche3.appendChild(doc.createTextNode("1985"));
				cochesU.appendChild(nCoche3);
				
				

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult("cd_catalog1.xml");

				transformer.transform(source, result);

				StreamResult consoleResult = new StreamResult(System.out);
				transformer.transform(source, consoleResult);

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
		public static void DOMirakurri() {
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
