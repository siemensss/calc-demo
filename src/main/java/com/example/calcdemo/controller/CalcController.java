package com.example.calcdemo.controller;


import com.example.calcdemo.service.CalcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/calculator")
@RestController
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService){
        this.calcService = calcService;
    }
    @GetMapping
    public String sayHello () {
        return calcService.sayHello();
    }
    @GetMapping(path = "/plus")
    public String sum (@RequestParam(value = "num1",required = false) String num1, @RequestParam (value = "num2",required = false) String num2) {
        if(num1 == null || num2 == null){
            return "Пожалуйста, заполните оба параметра!";
        }
        return num1 + " + " + num2 + " = " + calcService.sum(num1, num2);
    }
    @GetMapping(path = "/minus")
    public String sub (@RequestParam(value = "num1",required = false) String num1, @RequestParam (value = "num2",required = false) String num2) {
        if(num1 == null || num2 == null){
            return "Пожалуйста, заполните оба параметра!";
        }
        return num1 + " - " + num2 + " = " + calcService.sub(num1, num2);
    }
    @GetMapping(path = "/multiply")
    public String mult (@RequestParam(value = "num1", required = false) String num1, @RequestParam (value = "num2",required = false) String num2) {
        if(num1 == null || num2 == null){
            return "Пожалуйста, заполните оба параметра!";
        }
        return num1 + " * " + num2 + " = " + calcService.mult(num1, num2);
    }
    @GetMapping(path = "/divide")
    public String div (@RequestParam(value = "num1",required = false) String num1, @RequestParam (value = "num2",required = false) String num2) {
        if(num1 == null || num2 == null){
            return "Пожалуйста, заполните оба параметра!";
        }
        return num1 + " / " + num2 + " = " + calcService.div(num1, num2);
    }
}
