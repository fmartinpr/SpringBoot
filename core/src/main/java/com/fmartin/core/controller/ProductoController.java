/**
 * 
 */
package com.fmartin.core.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmartin.core.DTO.Mensaje;
import com.fmartin.core.entity.Producto;
import com.fmartin.core.service.ProductoService;

/**
 * @author fmgar
 *
 */

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> getLista() {
		List<Producto> lista = productoService.obtenerTodos();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}

	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		if (!productoService.existePorId(id)) {
			return new ResponseEntity<Mensaje>(new Mensaje("No existe ese producto"), HttpStatus.NOT_FOUND);
		} else {
			Producto producto = productoService.obtenerPorId(id).get();
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}
	}

	@PostMapping("/nuevo")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> create(@RequestBody Producto producto) {
		if (StringUtils.isBlank(producto.getNombre()))
			return new ResponseEntity<Mensaje>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if ((Integer) producto.getPrecio() == null || producto.getPrecio() == 0)
			return new ResponseEntity<Mensaje>(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
		if (productoService.existePorNombre(producto.getNombre()))
			return new ResponseEntity<Mensaje>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		producto = productoService.guardar(producto);
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}

	@PutMapping("/actualizar")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@RequestBody Producto producto) {
		if (!productoService.existePorId(producto.getId()))
			return new ResponseEntity<Mensaje>(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
		if (StringUtils.isBlank(producto.getNombre()))
			return new ResponseEntity<Mensaje>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if ((Integer) producto.getPrecio() == null || producto.getPrecio() == 0)
			return new ResponseEntity<Mensaje>(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
		if (productoService.existePorNombre(producto.getNombre())
				&& productoService.obtenerPorNombre(producto.getNombre()).get().getId() != producto.getId())
			return new ResponseEntity<Mensaje>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		producto = productoService.guardar(producto);
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}

	@DeleteMapping("/borrar/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if (!productoService.existePorId(id))
			return new ResponseEntity<Mensaje>(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
		productoService.borrar(id);
		return new ResponseEntity<Mensaje>(new Mensaje("producto eliminado"), HttpStatus.OK);
	}

}
