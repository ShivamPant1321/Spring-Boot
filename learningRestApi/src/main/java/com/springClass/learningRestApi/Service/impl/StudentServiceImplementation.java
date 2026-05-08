package com.springClass.learningRestApi.Service.impl;

import com.springClass.learningRestApi.Service.StudentService;
import com.springClass.learningRestApi.dto.AddStudentRequestDto;
import com.springClass.learningRestApi.dto.StudentDTO;
import com.springClass.learningRestApi.entity.Student;
import com.springClass.learningRestApi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student std = modelMapper.map(addStudentRequestDto, Student.class);
        Student newStudent = studentRepository.save(std);
        return modelMapper.map(newStudent, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Student not find with id: "+id);
        }
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student std =  studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not find with id: "+id));
//        std.setName(addStudentRequestDto.getName());
//        std.setEmail(addStudentRequestDto.getEmail());
        modelMapper.map(addStudentRequestDto, std);

        Student updStd = studentRepository.save(std);
        return modelMapper.map(updStd, StudentDTO.class);
    }

    @Override
    public StudentDTO patchStudent(Long id, Map<String, Object> updates) {
        Student std =  studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not find with id: "+id));

        updates.forEach((fields, values) -> {
            switch (fields){
                case "name":
                    std.setName((String)values);
                    break;
                case "email":
                    std.setEmail((String)values);
                    break;
                default: throw new IllegalArgumentException("Invalid fields: "+fields);
            }
        });
        Student updStd = studentRepository.save(std);
        return modelMapper.map(updStd, StudentDTO.class);
    }
}
