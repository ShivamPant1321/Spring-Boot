package com.SpringBootProject.MyHospitalManagementSystem.services;

import com.SpringBootProject.MyHospitalManagementSystem.dto.PatientDto;
import com.SpringBootProject.MyHospitalManagementSystem.entity.Patient;

import java.util.List;
import java.util.UUID;


public interface PatientService {

    List<PatientDto> getAllPatient();

    PatientDto getPatientById(Long id);
}
