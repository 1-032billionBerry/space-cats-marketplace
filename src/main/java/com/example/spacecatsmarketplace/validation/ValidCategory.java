package com.example.spacecatsmarketplace.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryValidator.class)
public @interface ValidCategory {

  String message() default "Invalid Category. It should contain space words";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
