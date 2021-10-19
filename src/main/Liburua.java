package main;

import java.io.Serializable;

public class Liburua implements Serializable{
	private String izenburua;
	private String argitaletxea;
	private String orrialdeak;
	private String altuera;
	private String oharrak;
	private String ISBN;
	private String gaiak;

	//ERAIKITZAILEA
	public Liburua() {

	}

	public Liburua(String izenburua, String argitaletxea, String orrialdeak, String altuera, String oharrak, String ISBN, String gaiak) {
		this.izenburua = izenburua;
		this.argitaletxea = argitaletxea;
		this.orrialdeak = orrialdeak;
		this.altuera = altuera;
		this.oharrak = oharrak;
		this.ISBN = ISBN;
		this.gaiak = gaiak;
	}

	//GETTERS & SETTERS
	public String getIzenburua() {
		return izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public String getArgitaletxea() {
		return argitaletxea;
	}

	public void setArgitaletxea(String argitaletxea) {
		this.argitaletxea = argitaletxea;
	}

	public String getOrrialdeak() {
		return orrialdeak;
	}

	public void setOrrialdeak(String orrialdeak) {
		this.orrialdeak = orrialdeak;
	}

	public String getAltuera() {
		return altuera;
	}

	public void setAltuera(String altuera) {
		this.altuera = altuera;
	}

	public String getOharrak() {
		return oharrak;
	}

	public void setOharrak(String oharrak) {
		this.oharrak = oharrak;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGaiak() {
		return gaiak;
	}

	public void setGaiak(String gaiak) {
		this.gaiak = gaiak;
	}

	@Override
	public String toString() {
		return "Izenburua: " + izenburua + "\nArgitaletxea: " + argitaletxea + "\nOrrialdeak: " + orrialdeak
				+ "\nAltuera: " + altuera + "\nOharrak: " + oharrak + "\nISBN: " + ISBN + "\nGaiak: " + gaiak;
	}	
}