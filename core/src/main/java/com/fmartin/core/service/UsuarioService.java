/**
 * 
 */
package com.fmartin.core.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
