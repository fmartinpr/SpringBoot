/**
 * 
 */
package com.notas.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author fmgar
 *
 */
@Entity
@Table(name="NOTA")
public class Nota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1165474281158866341L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOMBRE", unique=true)
	private String nombre;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRIPCION")
	private String contenido;
	
	public Nota() {
		
	}
	
	public Nota(Long id, String nombre, String titulo, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
}
