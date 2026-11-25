package com.SpringBootProject.MyHospitalManagementSystem.dto;

import com.SpringBootProject.MyHospitalManagementSystem.entity.type.BloodGroupType;
import com.SpringBootProject.MyHospitalManagementSystem.entity.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private BloodGroupType bloodGroupType;
    private String phoneNumber;
    private String address;
}
