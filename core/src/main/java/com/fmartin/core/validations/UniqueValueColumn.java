package com.fmartin.core.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValueColumnValidator.class)
@Documented
public @interface UniqueValueColumn {
	String message() default "El valor del campo debe ser único";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String table() default "";
    String column() default "NOMBRE";
}
