package com.example.calcdemo.service;


import com.example.calcdemo.exception.DivByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private final CalcServiceImpl calculatorService = new CalcServiceImpl();
    @Test
    public void sumTest(){
        int actual = calculatorService.sum("1", "2");
        int expected = 3;
        Assertions.assertEquals(expected, actual);

         actual = calculatorService.sum("-1", "2");
         expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void subTest(){
        int actual = calculatorService.sub("1", "2");
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.sub("-1", "2");
        expected = -3;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void multTest(){
        int actual = calculatorService.mult("1", "2");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.mult("-1", "2");
        expected = -2;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divTest(){
        double actual = calculatorService.div("1", "2");
        double expected = 0.5;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.div("-1", "2");
        expected = -0.5;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divNegativeTest(){
        Assertions.assertThrows(DivByZeroException.class,  () -> calculatorService.div("1", "0"));
        Assertions.assertThrows(DivByZeroException.class,  () -> calculatorService.div("-1", "0"));


    }



}
