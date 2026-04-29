package com.springClass.learningRestApi.Service;

import com.springClass.learningRestApi.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);
}
