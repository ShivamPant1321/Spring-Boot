package com.SpringBootProject.MyHospitalManagementSystem.services;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Patient;

import java.util.List;
import java.util.UUID;


public interface PatientService {

    List<Patient> getAllPatient();

    Patient getPatientById(UUID id);
}
