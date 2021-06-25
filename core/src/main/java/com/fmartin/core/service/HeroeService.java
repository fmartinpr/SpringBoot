package com.fmartin.core.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmartin.core.entity.Heroe;
import com.fmartin.core.exception.CoreException;
import com.fmartin.core.repository.HeroeRepository;

@Service
@Transactional
public class HeroeService {
	@Autowired
	HeroeRepository heroeRepository;

	public Heroe create(Heroe heroe) {
		heroe.setId(UUID.randomUUID().toString());
		return this.heroeRepository.save(heroe);
	}

	public Heroe update(Heroe heroe) {
		return this.heroeRepository.save(heroe);
	}

	public List<Heroe> getHeroes() {
		return this.heroeRepository.findAll();
	}

	public Heroe getById(String id) {
		return this.heroeRepository.findById(id).orElse(null);
	}

	public void delete(String id) throws CoreException {
		try {
			this.heroeRepository.deleteById(id);
		} catch (Exception e) {
			throw new CoreException("Error eliminar heroe");
		}
	}

}
