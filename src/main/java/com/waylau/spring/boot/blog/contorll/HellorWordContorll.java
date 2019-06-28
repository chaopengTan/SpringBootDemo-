package com.waylau.spring.boot.blog.contorll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellorWordContorll {
    @RequestMapping("/hello")
    public String hellor(){
        return "hello word";
    }
}
