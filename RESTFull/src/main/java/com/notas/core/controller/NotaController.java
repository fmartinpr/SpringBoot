package com.notas.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.core.entity.Nota;
import com.notas.core.service.NotaService;
import com.notas.core.model.MNota;

@RestController
@RequestMapping("/v1")
public class NotaController {
	@Autowired
	@Qualifier("servicio")
	private NotaService servicio;
	
	@GetMapping("/notas-paginacion")
	public List<MNota> obtenerNotasPaginadas(Pageable pageable){
		return servicio.obtenerPorPaginacion(pageable);
	}
	
	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		return servicio.actualizar(nota);
	}
	
	@PostMapping("/nota")
	public boolean actualizarNota(@RequestBody @Valid Nota nota) {
		return servicio.actualizar(nota);
	}
	
	@DeleteMapping("/nota/{id}/{nombre}")
	public boolean borrarNota(@PathVariable("id") Long id, 
			@PathVariable("nombre") String nombre) {
		return servicio.borrar(nombre, id);
	}
	
	@GetMapping("/notas")
	public List<MNota> obtenerNotas(){
		return servicio.obtener();
	}
	
}
