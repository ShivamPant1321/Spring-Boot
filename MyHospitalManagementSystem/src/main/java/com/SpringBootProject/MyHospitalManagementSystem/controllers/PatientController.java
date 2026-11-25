package com.SpringBootProject.MyHospitalManagementSystem.controllers;

import com.SpringBootProject.MyHospitalManagementSystem.dto.PatientDto;
import com.SpringBootProject.MyHospitalManagementSystem.entity.Patient;
import com.SpringBootProject.MyHospitalManagementSystem.services.PatientService;
import lombok.*;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

}
