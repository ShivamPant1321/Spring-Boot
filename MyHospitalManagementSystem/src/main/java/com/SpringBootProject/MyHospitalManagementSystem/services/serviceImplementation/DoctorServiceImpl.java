package com.SpringBootProject.MyHospitalManagementSystem.services.serviceImplementation;

import com.SpringBootProject.MyHospitalManagementSystem.dto.DoctorDto;
import com.SpringBootProject.MyHospitalManagementSystem.entity.Doctor;
import com.SpringBootProject.MyHospitalManagementSystem.repository.DoctorRepository;
import com.SpringBootProject.MyHospitalManagementSystem.services.DoctorService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorDto doctorDto = modelMapper.map(doctor, DoctorDto.class);
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return modelMapper.map(doctor, DoctorDto.class);
    }
}
