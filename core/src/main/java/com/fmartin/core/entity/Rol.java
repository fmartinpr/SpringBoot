/**
 * 
 */
package com.fmartin.core.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fmartin.core.enums.RolNombre;

/**
 * @author fmgar
 *
 */

@Entity
@Table(name="tt_rol")
public class Rol {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private RolNombre rolNombre;
	
	public Rol(){
		
	}

	/**
	 * @param rolNombre
	 */
	public Rol(@NotNull RolNombre rolNombre) {
		super();
		this.rolNombre = rolNombre;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the rolNombre
	 */
	public RolNombre getRolNombre() {
		return rolNombre;
	}

	/**
	 * @param rolNombre the rolNombre to set
	 */
	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}
	
}
