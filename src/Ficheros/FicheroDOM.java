package Ficheros;

import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import Metodoak.Liburua;

public class FicheroDOM {

	// __________________________________________________________________________________________________________________//

	public static boolean sartuDOM(Liburua lib) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse("./datuak/Liburuak.xml");

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

			StreamResult result = new StreamResult("./datuak/Liburuak.xml");

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// __________________________________________________________________________________________________________________//

public static boolean irakurriDOM() throws InterruptedException {
		
		System.out.println("\n" + "------------------------------------------------------");
		Thread.sleep(100);
		System.err.println("XML Fitxategia");
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			MiHandler miHandler = new MiHandler();
			SAXParser parser = factory.newSAXParser();
			parser.parse("./datuak/Liburuak.xml", miHandler);
			ArrayList<Liburua> Libros = miHandler.obtenerLiburu();

			for (Liburua lib : Libros) {
				System.out.println("------------------------------------------------------");
				
				Pattern pat = Pattern.compile(Metodoak.MetodoakPatroiak.izena);
				Matcher mat = pat.matcher(lib.getIzenburua());
				if(mat.matches()==true) {
					System.out.println("Izenburua: " + lib.getIzenburua());
				}else {
					lib.setIzenburua("0");
					System.out.println("Izenburua: " +  lib.getIzenburua());
				}
				Pattern pat1 = Pattern.compile(Metodoak.MetodoakPatroiak.izena);
				Matcher mat1 = pat1.matcher(lib.getArgitaletxea());
				if(mat1.matches()==true) {
					System.out.println("Argitaletxea: " + lib.getArgitaletxea());
				}else {
					lib.setArgitaletxea("0");
					System.out.println("Argitaletxea:"  +  lib.getArgitaletxea());
				}
				Pattern pat2 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
				Matcher mat2 = pat2.matcher(lib.getOrrialdeak());
				if(mat2.matches()==true) {
					System.out.println("Orrialdeak: " + lib.getOrrialdeak());
				}else {
					lib.setOrrialdeak("0");
					System.out.println("Orrialdeak: " + lib.getOrrialdeak());
				}
				Pattern pat3 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
				Matcher mat3 = pat3.matcher(lib.getAltuera());
				if(mat3.matches()==true) {
					System.out.println("Altuera: " + lib.getAltuera());
				}else {
					lib.setAltuera("0");
					System.out.println("Altuera: "+ lib.getAltuera());
				}
				Pattern pat4 = Pattern.compile(Metodoak.MetodoakPatroiak.texto);
				Matcher mat4 = pat4.matcher(lib.getOharrak());
				if(mat4.matches()==true) {
					System.out.println("Oharrak: " + lib.getOharrak());
				}else {
					lib.setOharrak("0");
					System.out.println("Oharrak: " + lib.getOharrak());
				}
				Pattern pat5 = Pattern.compile(Metodoak.MetodoakPatroiak.ISBN);
				Matcher mat5 = pat5.matcher(lib.getISBN());
				if(mat5.matches()==true) {
					System.out.println("ISBN: " + lib.getISBN());
				}else {
					lib.setISBN("0");
					System.out.println("ISBN: "+lib.getISBN());
				}
				Pattern pat6 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
				Matcher mat6 = pat6.matcher(lib.getGaiak());
				if(mat6.matches()==true) {
					System.out.println("Gaiak: " + lib.getGaiak());
				}else {
					lib.setGaiak("0");
					System.out.println("Gaiak: "+lib.getGaiak());
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		return true;
	}
	
	// __________________________________________________________________________________________________________________//
	
	public static boolean komprobatu(Liburua lib) throws InterruptedException {
		System.out.println("\n" + "------------------------------------------------------");
		Thread.sleep(100);
		System.err.println("XML Fitxategia");

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			MiHandler miHandler = new MiHandler();
			SAXParser parser = factory.newSAXParser();
			parser.parse("./datuak/Liburuak.xml", miHandler);

			System.out.println("------------------------------------------------------");

			Pattern pat = Pattern.compile(Metodoak.MetodoakPatroiak.izena);
			Matcher mat = pat.matcher(lib.getIzenburua());
			if(mat.matches()==true) {
				System.out.println("Izenburua: " + lib.getIzenburua());
			}else {
				lib.setIzenburua("Datu desegokia.");
				System.out.println("Izenburua: " +  lib.getIzenburua());
			}
			Pattern pat1 = Pattern.compile(Metodoak.MetodoakPatroiak.izena);
			Matcher mat1 = pat1.matcher(lib.getArgitaletxea());
			if(mat1.matches()==true) {
				System.out.println("Argitaletxea: " + lib.getArgitaletxea());
			}else {
				lib.setArgitaletxea("Datu desegokia.");
				System.out.println("Argitaletxea:"  +  lib.getArgitaletxea());
			}
			Pattern pat2 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
			Matcher mat2 = pat2.matcher(lib.getOrrialdeak());
			if(mat2.matches()==true) {
				System.out.println("Orrialdeak: " + lib.getOrrialdeak());
			}else {
				lib.setOrrialdeak("Datu desegokia.");
				System.out.println("Orrialdeak: " + lib.getOrrialdeak());
			}
			Pattern pat3 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
			Matcher mat3 = pat3.matcher(lib.getAltuera());
			if(mat3.matches()==true) {
				System.out.println("Altuera: " + lib.getAltuera());
			}else {
				lib.setAltuera("Datu desegokia.");
				System.out.println("Altuera: "+ lib.getAltuera());
			}
			Pattern pat4 = Pattern.compile(Metodoak.MetodoakPatroiak.texto);
			Matcher mat4 = pat4.matcher(lib.getOharrak());
			if(mat4.matches()==true) {
				System.out.println("Oharrak: " + lib.getOharrak());
			}else {
				lib.setOharrak("Datu desegokia.");
				System.out.println("Oharrak: " + lib.getOharrak());
			}
			Pattern pat5 = Pattern.compile(Metodoak.MetodoakPatroiak.ISBN);
			Matcher mat5 = pat5.matcher(lib.getISBN());
			if(mat5.matches()==true) {
				System.out.println("ISBN: " + lib.getISBN());
			}else {
				lib.setISBN("Datu desegokia.");
				System.out.println("ISBN: "+lib.getISBN());
			}
			Pattern pat6 = Pattern.compile(Metodoak.MetodoakPatroiak.zenbakia);
			Matcher mat6 = pat6.matcher(lib.getGaiak());
			if(mat6.matches()==true) {
				System.out.println("Gaiak: " + lib.getGaiak());
			}else {
				lib.setGaiak("Datu desegokia.");
				System.out.println("Gaiak: "+lib.getGaiak());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000); 
		return true;
	}
}
