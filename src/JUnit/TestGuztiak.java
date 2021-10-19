package JUnit;
import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;
import main.Liburua;

public class TestGuztiak {
	
	Scanner sc = new Scanner(System.in); 
	
	@Test
	public void testZenbakiaDa() {
		int zbk = 9;
		assertEquals(zbk, main.app.zenbakiaDa("9"));
	}

	@Test
	public void testGehituiburua() {
		
		Liburua l = new Liburua("Empire Burlesque", "Iturribide", "156", "12", "Bi ohar ditu", "234567", "2");
	
		assertEquals(l.getIzenburua(), main.app.gehituLiburu(sc).getIzenburua());
		
		}
	
}
