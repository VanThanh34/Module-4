package com.codegym.c0525g1_spring_boot.validation;

import com.codegym.c0525g1_spring_boot.repository.IStudentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        boolean isExists = studentRepository.findByEmail(s);
//        return !isExists;
        return true;
    }
}
