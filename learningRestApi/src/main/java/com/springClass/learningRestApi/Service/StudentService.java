package com.springClass.learningRestApi.Service;

import com.springClass.learningRestApi.dto.AddStudentRequestDto;
import com.springClass.learningRestApi.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDTO patchStudent(Long id, Map<String, Object> updates);
}
