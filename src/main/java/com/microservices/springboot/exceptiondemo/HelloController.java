package com.microservices.springboot.exceptiondemo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        if(name.indexOf("Neetin") < 0) throw new CustomException("only Neetin will be greeted");
        return "Hello " + name + "!";
    }

    @RequestMapping("/call/{number}")
    public String call(@PathVariable String number) {
        if(number.length() != 10) throw new RuntimeException("only 10 digit numbers allowed");
        return "Calling " + number + "!";
    }
}
