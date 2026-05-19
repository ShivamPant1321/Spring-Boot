package com.myspringclass.HospitalManagementSystem;


import com.myspringclass.HospitalManagementSystem.entity.Patient;
import com.myspringclass.HospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> patient = patientRepository.findAll();
        System.out.println(patient);
    }
}
