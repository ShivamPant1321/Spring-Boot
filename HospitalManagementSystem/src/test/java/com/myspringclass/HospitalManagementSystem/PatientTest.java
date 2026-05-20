package com.myspringclass.HospitalManagementSystem;


import com.myspringclass.HospitalManagementSystem.entity.Patient;
import com.myspringclass.HospitalManagementSystem.repository.PatientRepository;
import com.myspringclass.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patient = patientRepository.findAll();
        System.out.println(patient);
    }

    @Test
    public void testTractionMethods(){
        Patient p = patientService.getPatientById(1L);
        System.out.println(p);
    }
}
