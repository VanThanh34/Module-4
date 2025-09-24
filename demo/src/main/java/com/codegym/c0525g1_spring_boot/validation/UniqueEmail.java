package com.codegym.c0525g1_spring_boot.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class) // Link to your validator
@Documented
public @interface UniqueEmail {
    String message() default "Email đã tồn tại trong  hệ thống";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
