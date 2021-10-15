package fitxeroDOM;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiHandler extends DefaultHandler{
	
	boolean izenburua = false;
	boolean argitaletxea = false;
	boolean orrialdeak = false;
	boolean altuera = false;
	boolean oharrak = false;
	boolean isbn = false;
	boolean gaiak = false;
	private ArrayList<Liburua> liburu = new ArrayList<Liburua>();
	Liburua milibro = new Liburua();
	
	 @Override
	    public void startElement(String uri, String localName, String Name, Attributes attributos) throws SAXException {
	       	if(Name.equals("Izenburua"))
	       		izenburua = true;
	    	if(Name.equals("Argitaletxea"))
	    		argitaletxea = true;
	    	if(Name.equals("Orrialdeak"))
	    		orrialdeak = true;
	    	if(Name.equals("Altuera"))
	    		altuera = true;
	    	if(Name.equals("Oharrak"))
	    		oharrak = true;
	    	if(Name.equals("ISBN"))
	    		isbn = true;
	    	if(Name.equals("Gaiak"))
	    		gaiak = true;
		 
	    }
	 
	 
	  public ArrayList<Liburua> obtenerLiburu(){
		  return liburu;
	  }
	 
	    @Override
	    public void characters(char[] ch, int start, int length) throws SAXException {
	    
	        if(izenburua)
	        {
	        	milibro.setIzenburua(new String(ch, start, length));
	        	izenburua = false;
	        }
	        
	        if(argitaletxea)
	        {
	        	milibro.setArgitaletxea(new String(ch, start, length));
	        	argitaletxea = false;
	        }
	        
	        if(orrialdeak)
	        {
	        	milibro.setOrrialdeak(new String(ch, start, length));
	        	orrialdeak = false;
	        }
	        if(altuera)
	        {
	        	milibro.setAltuera(new String(ch, start, length));
	        	altuera = false;
	        }
	        if(oharrak)
	        {
	        	milibro.setOharrak(new String(ch, start, length));
	        	oharrak = false;
	        }
	        if(isbn)
	        {
	        	milibro.setISBN(new String(ch, start, length));
	        	isbn = false;
	        }
	        if(gaiak)
	        {
	        	milibro.setGaiak(new String(ch, start, length));
	        	gaiak = false;
	        }
	        
	        	
	    }
	 
	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	    	if(qName.equals("Liburua"))
	    	{
		    	liburu.add(milibro);
		    	milibro = new Liburua();
	    	}	
	       
	    }
}
