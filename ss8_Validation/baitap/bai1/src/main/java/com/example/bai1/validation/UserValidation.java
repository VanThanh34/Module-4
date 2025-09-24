package com.example.bai1.validation;

import com.example.bai1.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        Period period = Period.between(userDto.getDob(), LocalDate.now());
        if(period.getYears() < 18){
            errors.rejectValue("dob","","Phải đủ 18 tuổi mới được tham gia.");
        }
    }
}
