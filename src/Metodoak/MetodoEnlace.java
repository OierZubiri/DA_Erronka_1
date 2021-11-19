package Metodoak;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class MetodoEnlace {

	 public static boolean enlace (){
	        Desktop enlace=Desktop.getDesktop();
	        try {
	                enlace.browse(new URI("www.casadellibro.com"));
	        } catch (IOException | URISyntaxException e) {
	            e.getMessage();
	        }
	        return true;
	    }
}
