package Metodoak;

public class MetodoakPatroiak {
	public static String izena = "([A-Za-z]){1,30}";
	public static String ISBN = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})\r\n"
			+ "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)\r\n"
			+ "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$\r\n"
			+ "\r\n"
			+ ""; 
	public static String zenbakia = "([0-9]{2,4})";
	public static String zenbakiaMenua = "([0-3]){1}";
}
