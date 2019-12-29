/**
 * 
 */
package com.fmartin.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmartin.core.entity.Rol;
import com.fmartin.core.enums.RolNombre;
import com.fmartin.core.repository.RolRepository;

/**
 * @author fmgar
 *
 */
@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return this.rolRepository.findByRolNombre(rolNombre);
	}
}
