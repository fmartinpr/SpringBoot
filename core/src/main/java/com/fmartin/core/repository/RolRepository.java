/**
 * 
 */
package com.fmartin.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmartin.core.entity.Rol;
import com.fmartin.core.enums.RolNombre;

/**
 * @author fmgar
 *
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByRolNombre(RolNombre nombre);
}
