package com.SpringBootProject.MyHospitalManagementSystem.dto;


import com.SpringBootProject.MyHospitalManagementSystem.entity.type.Gender;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String phoneNumber;
}
