package com.example.appdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    @Autowired
            @Qualifier("students")
    UserService userService;

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return userService.getStudents();
    }

}
