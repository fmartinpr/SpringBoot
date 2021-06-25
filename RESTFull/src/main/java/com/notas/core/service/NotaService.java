package com.notas.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.notas.core.converter.Convertidor;
import com.notas.core.entity.Nota;
import com.notas.core.model.MNota;
import com.notas.core.repository.NotaRepository;

@Service("servicio")
public class NotaService {
	@Autowired
	@Qualifier("repositorio")
	private NotaRepository repositorio;

	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public List<MNota> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
		
	}
	
	private static final Log logger = LogFactory.getLog(NotaService.class); 
	
	public List<MNota> obtener() {
		return convertidor.convertirLista(repositorio.findAll());
	}

	public MNota obtenerPorNombreYTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	public boolean actualizar(Nota nota) {
		try {
			logger.info("ACTUALIZANDO NOTA");
			repositorio.save(nota);
			logger.info("NOTA ACTUALIZADA");
			return true;
		} catch (Exception ex) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}

	public boolean borrar(String nombre, Long id) {
		try {
			logger.warn("ELIMINANDO NOTA");
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			logger.warn("ELIMINAR NOTA");
			return true;
		} catch (Exception ex) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
}
