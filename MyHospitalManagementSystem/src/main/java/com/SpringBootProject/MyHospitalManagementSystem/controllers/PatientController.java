package com.SpringBootProject.MyHospitalManagementSystem.controllers;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Patient;
import com.SpringBootProject.MyHospitalManagementSystem.services.PatientService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Getter
@Setter
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable UUID id){
        return patientService.getPatientById(id);
    }

}
