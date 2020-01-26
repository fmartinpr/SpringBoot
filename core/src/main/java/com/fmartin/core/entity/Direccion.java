/**
 * 
 */
package com.fmartin.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author fmgar
 *
 */

@Entity
@Table(name="direccion")
public class Direccion implements Serializable{
	
	private static final long serialVersionUID = 443308091589467062L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String direccion;
	
	@NotNull
	private String provincia;
	
	/**
	 * 
	 */
	public Direccion() {

	}
	
	/**
	 * @param direccion
	 * @param provincia
	 */
	public Direccion(String direccion, String provincia) {
		this.direccion = direccion;
		this.provincia = provincia;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Direccion [direccion=" + direccion + ", provincia=" + provincia + "]";
	}
	
}
