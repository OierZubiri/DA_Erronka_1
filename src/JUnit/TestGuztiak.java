package JUnit;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.File;
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
	Liburua l = new Liburua("Empire Burlesque", "Iturribide", "156", "12", "Bi ohar ditu", "0-596-52068-9", "2");

	@Test
	public void testGehituiburua() {
		String input = "Empire Burlesque\nIturribide\n156\n12\nBi ohar ditu\n0-596-52068-9\n2";
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
	public void testGetLibros() {
		assertEquals(Metodoak.MetodoLiburuak.Libros, Metodoak.MetodoLiburuak.getLibros());
	}

	@Test
	public void testIzenburua() {
		String input = "Empire Burlesque";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.izenburua(false, reader));
	}

	@Test
	public void testArgitaletxea() {
		String input = "Iturribide";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.argitaletxea(false, reader));
	}

	@Test
	public void testOrrialdeak() {
		String input = "12";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.orrialdeak(false, reader));
	}

	@Test
	public void testAltuera() {
		String input = "12";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.altuera(false, reader));
	}

	@Test
	public void testOharrak() {
		String input = "Bi ohar ditu";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.oharrak(false, reader));
	}

	@Test
	public void testISBN() {
		String input = "0-596-52068-9";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.ISBN(false, reader));
	}

	@Test
	public void testGaiak() {
		String input = "12";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertEquals(input, Metodoak.MetodoKomprobaketak.gaiak(false, reader));
	}

	@Test
	public void testKomprobatuTXT() throws InterruptedException {
		assertEquals("", Ficheros.FicheroTXT.komprobatu(""));
	}

	@Test
	public void testKomprobatuDOM() throws InterruptedException{
		assertTrue(Ficheros.FicheroDOM.komprobatu(l));
	}

	@Test
	public void testKomprobatuDAT() throws InterruptedException {
		assertTrue(Ficheros.FicheroDAT.komprobatu(l));
	}

	@Test
	public void testBilatuTXT() throws InterruptedException{
		assertTrue(Metodoak.MetodoakBilatu.bilatuTXT(1, "hola"));
	}

	@Test
	public void testBilatuLiburua() throws InterruptedException {
		String input = "1\nEmpire";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertTrue(Metodoak.MetodoakBilatu.bilatuLiburua(reader));
	}

	@Test
	public void testAukera() throws InterruptedException {
		String input = "Empire";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner reader = new Scanner(System.in);
		assertTrue(Metodoak.MetodoakBilatu.aukera(input, 1,reader));
	}

	
	@Test
	public void bilatuFitxeroa() throws IOException {
		assertTrue(Metodoak.MetodoKokapena.bilatuFitxeroa(""));
	}
	
	@Test
	public void findFile() throws IOException {
		
		assertTrue(Metodoak.MetodoKokapena.findFile("/Liburuak.xml", new File(System.getProperty("user.home") + "/desktop")));
	}
	
	@Test
	public void guardarRuta() throws IOException {
		assertTrue(Metodoak.MetodoKokapena.guardarRuta(""));
	}
}
