package com.in28minutes.springboot.learnspringboot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(CourseController.class)
public class CourseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseController courseController;

    @Test
    public void testRetrieveAllCourses() throws Exception {
        List<Course> courses = Arrays.asList(
                new Course(1, "Learn AWS", "in28minutes"),
                new Course(2, "Learn Full stack with Spring Boot and Angular", "in28minutes"),
                new Course(3, "Hungry", "in28minutes"),
                new Course(4, "Master Microservices with Spring Boot and Spring Cloud", "in28minutes")
        );

        Mockito.when(courseController.retrieveAllCourses()).thenReturn(courses);

        mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Learn AWS"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author").value("in28minutes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Learn Full stack with Spring Boot and Angular"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].author").value("in28minutes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value("Hungry"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].author").value("in28minutes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].name").value("Master Microservices with Spring Boot and Spring Cloud"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].author").value("in28minutes"));
    }
}