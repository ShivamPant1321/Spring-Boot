package com.SpringBootProject.MyHospitalManagementSystem.services;

import com.SpringBootProject.MyHospitalManagementSystem.dto.DoctorDto;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(UUID id);
}
