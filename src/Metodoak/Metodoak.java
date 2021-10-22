package Metodoak;

@SuppressWarnings("serial")
class ArgumentuaHutsik extends RuntimeException {
	public ArgumentuaHutsik() {
	};
}

@SuppressWarnings("serial")
class ZenbakiaDa1 extends RuntimeException {
	public ZenbakiaDa1() {
	};
}

public class Metodoak {

	//***************************************************************************************************************************//

	public static int zenbakiaDa(String zbks) { 
		int zbk = 0;
		try {
			zbk = Integer.parseInt(zbks);
		} catch (Exception e) {
			System.out.println("Ez duzu zenbaki bat sartu");
			zbk = -1;
		}
		return zbk;
	}	
}
