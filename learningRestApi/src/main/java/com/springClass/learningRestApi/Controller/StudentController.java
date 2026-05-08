package com.springClass.learningRestApi.Controller;


import com.springClass.learningRestApi.Service.StudentService;
import com.springClass.learningRestApi.dto.AddStudentRequestDto;
import com.springClass.learningRestApi.dto.StudentDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/students")
@RequestMapping("/students")
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

    private final StudentService studentService;

//    @GetMapping("/student")
//    public List<Student> getStudent(){
//        return studentRepository.findAll();
//    }

    //Get Method

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
//        return studentService.getStudentById(id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Post Method
    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> patchStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.patchStudent(id, updates));
    }
}

