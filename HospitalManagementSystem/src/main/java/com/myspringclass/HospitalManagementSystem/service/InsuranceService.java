package com.myspringclass.HospitalManagementSystem.service;


import com.myspringclass.HospitalManagementSystem.entity.Insurance;
import com.myspringclass.HospitalManagementSystem.entity.Patient;
import com.myspringclass.HospitalManagementSystem.repository.InsuranceRepository;
import com.myspringclass.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id"+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bidirectional consistency maintanance

        return patient;
    }

    public Patient disassociateInsurancePatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id"+patientId));

        patient.setInsurance(null);
        return patient;
    }
}
