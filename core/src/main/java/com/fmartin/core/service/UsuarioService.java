/**
 * 
 */
package com.fmartin.core.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fmartin.core.entity.Rol;
import com.fmartin.core.entity.Usuario;
import com.fmartin.core.repository.UsuarioRepository;

/**
 * @author fmgar
 *
 */
@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Optional<Usuario> getByNombreUsuario(String nombre) {
		return this.usuarioRepository.findByNombre(nombre);
	}
	
	public boolean existePorNombre(String nombre) {
		return this.usuarioRepository.existsByNombreUsuario(nombre);
	}
	
	public boolean existePorEmail(String email) {
		return this.usuarioRepository.existsByEmail(email);
	}
	
	public void guardar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}

	/**
	 * @param id
	 * @return Usuario
	 */
	public Optional<Usuario> getByIdUsuario(Long id) {
		return this.usuarioRepository.findById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public Set<Rol> getByIdUsuarioRoles(Long id) {
		return this.usuarioRepository.getRolesById(id).getRoles();
	}

public List<SimpleGrantedAuthority> getAuthorities() {
	return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(this :: convertSimpleGrantedAuthority).collect(Collectors.toList());
}

private SimpleGrantedAuthority convertSimpleGrantedAuthority(GrantedAuthority a){
	if(a == null) return null;
	else return (SimpleGrantedAuthority)a;
}
	
}
