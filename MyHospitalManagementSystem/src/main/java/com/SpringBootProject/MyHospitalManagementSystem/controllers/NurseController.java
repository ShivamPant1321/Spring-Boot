package com.SpringBootProject.MyHospitalManagementSystem.controllers;

import com.SpringBootProject.MyHospitalManagementSystem.dto.NurseDto;
import com.SpringBootProject.MyHospitalManagementSystem.services.NurseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nurses")
@RequiredArgsConstructor
@Getter
@Setter
public class NurseController {
    private final NurseService nurseService;

    @GetMapping
    private ResponseEntity<List<NurseDto>> getAllNurses(){
        return ResponseEntity.status(HttpStatus.OK).body(nurseService.getAllNurses());
    }

    @GetMapping("/{id}")
    private ResponseEntity<NurseDto> getNurseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(nurseService.getNurseById(id));
    }

}
