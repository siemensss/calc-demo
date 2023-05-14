package com.example.calcdemo.service;



import com.example.calcdemo.exception.DivByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {
@Override
    public String sayHello () {
        return "Добро пожаловать в калькулятор";
    }
    @Override
    public int sum (String num1, String num2) {
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }
    @Override
    public int sub (String num1, String num2) {
        return Integer.parseInt(num1) - Integer.parseInt(num2);
    }
    @Override
    public int mult (String num1, String num2) {
        return Integer.parseInt(num1) * Integer.parseInt(num2);
    }
    @Override
    public double div ( String num1,  String num2) {
        if(Integer.parseInt(num2) == 0){
            throw new DivByZeroException();
        }
    return (double) Integer.parseInt(num1) / Integer.parseInt(num2);
    }
}
