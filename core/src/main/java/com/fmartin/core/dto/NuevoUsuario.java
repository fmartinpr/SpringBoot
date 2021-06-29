/**
 * 
 */
package com.fmartin.core.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fmartin.core.validations.FieldsValueMatch;
import com.fmartin.core.validations.UniqueValueColumn;
import com.fmartin.core.validations.UniqueValueColumnValidator;

/**
 * @author fmgar
 *
 */
@FieldsValueMatch.List({
	@FieldsValueMatch(
			field = "password", 
			fieldMatch = "verifyPassword", 
			message = "¡Las contraseñas no coinciden!"),
	@FieldsValueMatch(
			field = "email", 
			fieldMatch = "email", 
			message = "¡Las direcciones de correo no coinciden!") 
})
public class NuevoUsuario {

	@NotBlank(message = "El campo nombre no puede estar vacio")
	private String nombre;

	@NotBlank(message = "El campo email no puede estar vacio")
	@Email(message = "El campo email no tiene un formato de email correcto")
	@UniqueValueColumn(table = UniqueValueColumnValidator.TABLE_USUARIO, column = UniqueValueColumnValidator.COLUMN_EMAIL, message = "Email de usuario repetido")
	private String email;

	@NotBlank(message = "El campo nombre de usuario no puede estar vacio")
	@UniqueValueColumn(table = UniqueValueColumnValidator.TABLE_USUARIO, message = "Nombre de usuario repetido")
	private String nombreUsuario;

	@NotBlank(message = "El campo password no puede estar vacio")
	private String password;

	private String verifyPassword;

	private Set<String> roles;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

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

	/**
	 * @return the roles
	 */
	public Set<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

}
