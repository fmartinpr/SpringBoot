/**
 * 
 */
package com.fmartin.core.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmartin.core.entity.Producto;
import com.fmartin.core.repository.ProductoRepository;

/**
 * @author fmgar
 *
 */

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> obtenerTodos(){
        List<Producto> lista = productoRepository.findAll();
        return lista;
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public Optional<Producto> obtenerPorNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public void borrar(Long id){
        productoRepository.deleteById(id);
    }

    public boolean existePorNombre(String nombre){
        return productoRepository.existsByNombre(nombre);
    }

    public boolean existePorId(Long id){
        return productoRepository.existsById(id);
    }

}
