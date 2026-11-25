package com.SpringBootProject.MyHospitalManagementSystem.services;

import com.SpringBootProject.MyHospitalManagementSystem.dto.NurseDto;

import java.util.List;

public interface NurseService {
    List<NurseDto> getAllNurses();

    NurseDto getNurseById(Long id);
}
