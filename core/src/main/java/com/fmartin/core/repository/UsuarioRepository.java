/**
 * 
 */
package com.fmartin.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmartin.core.entity.Usuario;

/**
 * @author fmgar
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByNombre(String nombre);
	boolean existsByNombreUsuario(String nombre);
	boolean existsByEmail(String email);
}
