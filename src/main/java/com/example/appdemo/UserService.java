package com.example.appdemo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("students")
public class UserService {

    public List<Student> getStudents(){
        return List.of(new Student(1, "Harry", "Harry@123"),
                        new Student(2, "John", "John@345"));
    }
}
