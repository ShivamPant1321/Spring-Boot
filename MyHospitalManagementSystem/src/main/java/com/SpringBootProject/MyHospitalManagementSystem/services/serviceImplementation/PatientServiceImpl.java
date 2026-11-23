package com.SpringBootProject.MyHospitalManagementSystem.services.serviceImplementation;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Patient;
import com.SpringBootProject.MyHospitalManagementSystem.repository.PatientRepository;
import com.SpringBootProject.MyHospitalManagementSystem.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return new ArrayList<>(patientRepository.findAll());
    }

    @Override
    public Patient getPatientById(UUID id) {
        return patientRepository.findById((UUID) id).orElseThrow();
    }
}
