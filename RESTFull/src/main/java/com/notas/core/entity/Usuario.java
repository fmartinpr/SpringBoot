package com.notas.core.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table
public class Usuario implements UserDetails, Serializable{
	
	private static final long serialVersionUID = -7722887051788610309L;

	@GeneratedValue
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="USUARIO", unique = true)
	private String usuario;
	
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(		
	  name = "USUARIO_ROL", 
	  joinColumns = @JoinColumn(name = "USUARIO_ID"), 
	  inverseJoinColumns = @JoinColumn(name = "ROL_ID"))
	private Set<Rol> roles;
	
	@Column(name="ACTIVO")
	private boolean activo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return activo;
	}

	@Override
	public boolean isAccountNonLocked() {
		return activo;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return activo;
	}

	@Override
	public boolean isEnabled() {
		return activo;
	}
	
}
