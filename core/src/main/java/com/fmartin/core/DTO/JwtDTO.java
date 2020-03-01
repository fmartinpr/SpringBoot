/**
 * 
 */
package com.fmartin.core.DTO;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author fmgar
 *
 */
public class JwtDTO {
	
	private String token;
	private String bearer = "Bearer";
	private String nombreUsuario;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDTO(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.nombreUsuario = nombreUsuario;
		this.authorities = authorities;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the bearer
	 */
	public String getBearer() {
		return bearer;
	}

	/**
	 * @param bearer the bearer to set
	 */
	public void setBearer(String bearer) {
		this.bearer = bearer;
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
	 * @return the authorities
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
