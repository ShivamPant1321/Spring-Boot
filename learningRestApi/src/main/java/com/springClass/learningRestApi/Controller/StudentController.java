package com.springClass.learningRestApi.Controller;


import com.springClass.learningRestApi.Service.StudentService;
import com.springClass.learningRestApi.dto.StudentDTO;
import com.springClass.learningRestApi.entity.Student;
import com.springClass.learningRestApi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
//
//    @GetMapping("/student")
//    public StudentDTO getStudent(){
//        return new StudentDTO(4L, "Rahul", "rahul22@gmail.com");
//    }
//
//    @GetMapping("/student/{id}")
//    public StudentDTO getStudentById(@PathVariable Long id){
//        return new StudentDTO(4L, "Rahul", "rahul22@gmail.com");
//    }

//    private final StudentRepository studentRepository;
//    public StudentController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    private StudentService studentService;

//    @GetMapping("/student")
//    public List<Student> getStudent(){
//        return studentRepository.findAll();
//    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
