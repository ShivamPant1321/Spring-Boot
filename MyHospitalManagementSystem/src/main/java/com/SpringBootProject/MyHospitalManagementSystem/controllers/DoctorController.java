package com.SpringBootProject.MyHospitalManagementSystem.controllers;

import com.SpringBootProject.MyHospitalManagementSystem.dto.DoctorDto;
import com.SpringBootProject.MyHospitalManagementSystem.services.DoctorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
@Getter
@Setter
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllPatients(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public DoctorDto getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }
}
