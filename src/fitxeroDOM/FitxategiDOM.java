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

import main.Liburua;

public class FitxategiDOM {
	
	
	
	public static void DOMidatzi(Liburua lib) throws ParserConfigurationException, SAXException, IOException {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("Liburuak.xml");
			
			try {
				Element elementoRaiz = doc.getDocumentElement();

				Element liburuak = doc.createElement("Liburua");
				elementoRaiz.appendChild(liburuak);

				Element izenburua = doc.createElement("Izenburua");
				izenburua.appendChild(doc.createTextNode(lib.getIzenburua()));
				liburuak.appendChild(izenburua);
				
				Element argitaletxea = doc.createElement("Argitaletxea");
				argitaletxea.appendChild(doc.createTextNode(lib.getArgitaletxea()));
				liburuak.appendChild(argitaletxea);
				
				Element orrialdeak = doc.createElement("Orrialdeak");
				orrialdeak.appendChild(doc.createTextNode(lib.getOrrialdeak()));
				liburuak.appendChild(orrialdeak);
				
				Element altuera = doc.createElement("Altuera");
				altuera.appendChild(doc.createTextNode(lib.getAltuera()));
				liburuak.appendChild(altuera);
				
				Element oharrak = doc.createElement("Oharrak");
				oharrak.appendChild(doc.createTextNode(lib.getOharrak()));
				liburuak.appendChild(oharrak);
				
				Element isbn = doc.createElement("ISBN");
				isbn.appendChild(doc.createTextNode(lib.getISBN()));
				liburuak.appendChild(isbn);
				
				Element gaiak = doc.createElement("Gaiak");
				gaiak.appendChild(doc.createTextNode(lib.getGaiak()));
				liburuak.appendChild(gaiak);
				
				

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult("Liburuak.xml");

				transformer.transform(source, result);

				

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
			e.printStackTrace();
		} catch (SAXException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
}
