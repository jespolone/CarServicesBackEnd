package com.jespApiTest.CarServices;

public class CarService {
	private String targa;
	private String colore;
	private String modello;
	private String marca;
	private int anno;
	

	
	public CarService(String targa, String colore, String modello, String marca, int anno ) {
		this.targa = targa;
		this.colore = colore;
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
	}
	
	public String getTarga() {
		return this.targa;
	}
	
	public String getColore() {
		return this.colore;
	}
	public String getModello() {
		return this.modello;
	}
	public String getMarca() {
		return this.marca;
	}
	public int getAnno() {
		return this.anno;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
	

}
