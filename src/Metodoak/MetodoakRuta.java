package Metodoak;

import java.io.File;

public class MetodoakRuta {

	public static String ruta;

	// __________________________________________________________________________________________________________________//

	public static boolean bilatuFitxeroa(String name) {
		File file;
		
		if(System.getProperty("os.name").equals("Linux")) {
			file = new File(System.getProperty("user.home"));
		}else {
			file = new File("C:\\Aldapena");
		}

		findFile(name, file);

		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean findFile(String name, File file) {

		File[] list = file.listFiles();
		if (list != null)
			for (File fil : list) {
				if (fil.isDirectory()) {
					findFile(name, fil);
				} else if (name.equalsIgnoreCase(fil.getName())) {
					guardarRuta(fil.getParentFile().toString());
				}
			}
		return true;
	}

	// __________________________________________________________________________________________________________________//

	public static boolean guardarRuta(String rutaDefinitiva) {
		ruta = rutaDefinitiva;
		return true;
	}
}
