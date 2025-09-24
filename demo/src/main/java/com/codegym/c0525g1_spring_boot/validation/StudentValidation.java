package com.codegym.c0525g1_spring_boot.validation;

import com.codegym.c0525g1_spring_boot.dto.StudentDto;
import com.codegym.c0525g1_spring_boot.entity.Student;
import com.codegym.c0525g1_spring_boot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class StudentValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        Period period = Period.between(studentDto.getDob(), LocalDate.now());
        if(period.getYears() <18) {
            errors.rejectValue("dob", "", "Phải đủ  18 tuổi");
        }

    }
}
