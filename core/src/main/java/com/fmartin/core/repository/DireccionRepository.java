/**
 * 
 */
package com.fmartin.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmartin.core.entity.Direccion;

/**
 * @author fmgar
 *
 */

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}
