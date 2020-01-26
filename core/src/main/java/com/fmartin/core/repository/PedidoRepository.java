/**
 * 
 */
package com.fmartin.core.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fmartin.core.entity.Pedido;

/**
 * @author fmgar
 *
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	/**
	 * @return
	 */
	@Query("SELECT p FROM Pedido p "
			+ "join fetch p.lineas "
			+ "join fetch p.direcciones "
			+ "join fetch p.usuario")
	Set<Pedido> findAllFetch();

}
