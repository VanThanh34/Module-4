package com.codegym.service.impl;

import com.codegym.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {
    @Override
    public double calculate(double num1, double num2, String operation) throws ArithmeticException {
        switch (operation) {
            case "Addition":
                return num1 + num2;
            case "Subtraction":
                return num1 - num2;
            case "Multiplication":
                return num1 * num2;
            case "Division":
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return num1 / num2;
        }
        return 0;
    }
}
