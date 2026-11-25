package com.SpringBootProject.MyHospitalManagementSystem.dto;

import com.SpringBootProject.MyHospitalManagementSystem.entity.type.BloodGroupType;
import com.SpringBootProject.MyHospitalManagementSystem.entity.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialty;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Gender gender;
}
