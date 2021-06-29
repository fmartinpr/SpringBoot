package com.fmartin.core.dto;

import java.io.Serializable;

public class HeroeDto implements Serializable{

	private static final long serialVersionUID = -3319995953218609380L;

	private String id; 

	private String nombre;

	private String poder;
	
	private boolean vivo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	
}
