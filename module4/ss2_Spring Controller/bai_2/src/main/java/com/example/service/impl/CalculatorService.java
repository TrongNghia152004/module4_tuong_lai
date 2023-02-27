package com.example.service.impl;

import com.example.service.ICalculatorService;

public class CalculatorService implements ICalculatorService {
    @Override
    public double performCalculator(String calculate, double firstNumber, double secondNumber) {

        switch (calculate){
            case "Addition":
                return firstNumber + secondNumber;
            case "Subtraction":
                return firstNumber - secondNumber;
            case "Multiplication":
                return firstNumber * secondNumber;
            case "Division":
                if (secondNumber != 0){
                    return firstNumber / secondNumber;
                }else {
                    return 0;
                }
            default:
        }
            return 0;
    }
}
