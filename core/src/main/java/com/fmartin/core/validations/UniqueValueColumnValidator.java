package com.fmartin.core.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmartin.core.service.UsuarioService;

public class UniqueValueColumnValidator implements ConstraintValidator<UniqueValueColumn, String> {
	public static final String TABLE_USUARIO = "USUARIO";
	public static final String COLUMN_NOMBRE = "NOMBRE";
	public static final String COLUMN_EMAIL = "EMAIL";

	@Autowired
	UsuarioService usuarioService;
	
	private String table;
	private String column;
	
	@Override
	public void initialize(UniqueValueColumn constraintAnnotation) {
		this.table = constraintAnnotation.table();
		this.column = constraintAnnotation.column();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext cxt) {
		if(this.table.isEmpty()) return false;
		if(this.table.equalsIgnoreCase(TABLE_USUARIO) && this.column.equalsIgnoreCase(COLUMN_NOMBRE)) return !this.usuarioService.existePorNombre(value);
		if(this.table.equalsIgnoreCase(TABLE_USUARIO) && this.column.equalsIgnoreCase(COLUMN_EMAIL)) return !usuarioService.existePorEmail(value);
		return false;
	}

}
