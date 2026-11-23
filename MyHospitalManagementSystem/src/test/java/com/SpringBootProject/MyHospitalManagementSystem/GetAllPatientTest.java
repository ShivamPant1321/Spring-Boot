package com.SpringBootProject.MyHospitalManagementSystem;

import com.SpringBootProject.MyHospitalManagementSystem.dto.PatientDto;
import com.SpringBootProject.MyHospitalManagementSystem.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GetAllPatientTest {

    @Autowired
    private PatientService patientService;

    @Test
    void getAllPatient() {
        List<PatientDto> patientDtoList = patientService.getAllPatient();

        for (PatientDto patientDto : patientDtoList) {
            System.out.println(patientDto);
        }
    }
}
