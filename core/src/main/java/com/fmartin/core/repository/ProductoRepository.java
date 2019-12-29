/**
 * 
 */
package com.fmartin.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmartin.core.entity.Producto;

/**
 * @author fmgar
 *
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	Optional<Producto> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
}
