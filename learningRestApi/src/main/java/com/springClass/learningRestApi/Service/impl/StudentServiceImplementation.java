package com.springClass.learningRestApi.Service.impl;

import com.springClass.learningRestApi.Service.StudentService;
import com.springClass.learningRestApi.dto.StudentDTO;
import com.springClass.learningRestApi.entity.Student;
import com.springClass.learningRestApi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> stdDTOList = students.stream().map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail())).toList();
        return stdDTOList;
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student std =  studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not find with id: "+id));
//        return new StudentDTO(std.getId(), std.getName(), std.getEmail());
        StudentDTO stdDTO = modelMapper.map(std, StudentDTO.class);
        return stdDTO;
    }
}
