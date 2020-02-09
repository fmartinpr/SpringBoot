/**
 * 
 */
package com.fmartin.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmartin.core.repository.LineaPedidoRepository;

/**
 * @author fmgar
 *
 */
@Service
@Transactional
public class LineaPedidoService {
	
	@Autowired
	LineaPedidoRepository lineaPedidoRepository;
	
	public boolean eliminar(Long id) {
		this.lineaPedidoRepository.deleteById(id);
		return true;
	}

}
