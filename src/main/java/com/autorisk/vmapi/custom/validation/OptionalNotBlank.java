package com.autorisk.vmapi.custom.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = OptionaNotBlankValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptionalNotBlank {
    String message() default "Must not be blank if present.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
