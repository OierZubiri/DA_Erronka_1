package Metodoak;

public class MetodoakPatroiak {
	public static String izena = "([A-Za-z1-9 ]){1,30}";
	public static String texto = "([A-Za-z1-9 ]){1,300}";
	public static String ISBN = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
	public static String zenbakia = "([0-9]{2,4})";
	//Ejemplo ISBN: 0-596-52068-9
	public static String zenbakiaMenua = "([1-4]){1}";
	public static String zenbakiaBilatu = "([1-7]){1}";
}
