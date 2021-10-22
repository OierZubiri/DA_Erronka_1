package JUnit;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import Ficheros.FicheroDAT;
import Ficheros.FicheroDOM;
import Ficheros.FicheroTXT;
import Metodoak.Liburua;

public class TestGuztiak {

	Scanner sc = new Scanner(System.in);
	Liburua l = new Liburua("Empire Burlesque", "Iturribide", "156", "12", "Bi ohar ditu", "234567", "2");
	
	@Test
	public void testZenbakiaDa() {
		int zbk = 9;
		assertEquals(zbk, Metodoak.Metodoak.zenbakiaDa("9"));
	}

	@Test
	public void testGehituiburua() {
		String input = "Empire Burlesque\nIturribide\n156\n12\nBi ohar ditu\n234567\n2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
		
		assertEquals(l.getIzenburua(), Metodoak.MetodoLiburuak.gehituLiburu(reader).getIzenburua());

	}

	@Test
	public void testSartuDAT() {

		assertTrue(FicheroDAT.sartuDAT());

	}

	@Test
	public void testIrakuriDAT() throws ClassNotFoundException, IOException, InterruptedException {

		assertTrue(FicheroDAT.irakurriDAT());

	}

	@Test
	public void testSartuDOM() throws ParserConfigurationException, SAXException, IOException {

		assertTrue(FicheroDOM.sartuDOM(l));

	}

	@Test
	public void testIrakuriDOM() throws ClassNotFoundException, IOException, InterruptedException {

		assertTrue(FicheroDOM.irakurriDOM());

	}

	@Test
	public void testSartuTXT() {

		assertTrue(FicheroDAT.sartuDAT());

	}

	@Test
	public void testIrakuriTXT() throws ClassNotFoundException, IOException, InterruptedException {

		assertTrue(FicheroTXT.irakurriTXT());

	}
	
	@Test
	public void testGetLibros(){

		assertEquals(Metodoak.MetodoLiburuak.Libros, Metodoak.MetodoLiburuak.getLibros());

	}

	@Test
	public void testSetLibros(){

		assertTrue(Metodoak.MetodoLiburuak.setLibros(Metodoak.MetodoLiburuak.Libros));

	}
	
}
