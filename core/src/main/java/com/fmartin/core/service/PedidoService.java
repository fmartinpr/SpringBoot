/**
 * 
 */
package com.fmartin.core.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmartin.core.entity.Pedido;
import com.fmartin.core.repository.PedidoRepository;

/**
 * @author fmgar
 *
 */

@Service
@Transactional
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido guardar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> guardar(List<Pedido> pedidos) {
		return pedidoRepository.saveAll(pedidos);
	}
	
	public List<Pedido> mostrarTodos(){
		return this.pedidoRepository.findAll();
	}
	
	public Set<Pedido> mostrarTodosFetch(){
		return this.pedidoRepository.findAllFetch();
	}

}
