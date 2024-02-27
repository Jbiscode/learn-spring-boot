package com.in28minutes.springboot.learnspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @GetMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(new Course(1,"Learn AWS","in28minutes"),
                new Course(2,"Learn Full stack with Spring Boot and Angular","in28minutes"),
                new Course(3,"Hungry","in28minutes"),
                new Course(4,"Master Microservices with Spring Boot and Spring Cloud","in28minutes"));
    }
}
