/**
 * 
 */
package com.fmartin.core.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author fmgar
 *
 */
public class LoginUsuario {
	
	@NotBlank
	private String nombreUsuario;
	
	@NotBlank
	private String password;

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
