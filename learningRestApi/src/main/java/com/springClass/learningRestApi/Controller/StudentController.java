package com.springClass.learningRestApi.Controller;


import com.springClass.learningRestApi.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDTO getStudent(){
        return new StudentDTO(4L, "Rahul", "rahul22@gmail.com");
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return new StudentDTO(4L, "Rahul", "rahul22@gmail.com");
    }
}
