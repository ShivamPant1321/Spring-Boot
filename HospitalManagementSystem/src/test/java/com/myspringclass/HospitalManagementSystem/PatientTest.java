package com.myspringclass.HospitalManagementSystem;


import com.myspringclass.HospitalManagementSystem.dto.GenderResponseEntity;
import com.myspringclass.HospitalManagementSystem.entity.Patient;
import com.myspringclass.HospitalManagementSystem.repository.PatientRepository;
import com.myspringclass.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
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
//        Patient p = patientService.getPatientById(16L);
//        System.out.println(p);

//        Patient patient =  patientRepository.findByName("Manav");
//        System.out.println(patient);
//

//        List<Patient> patient = patientRepository.findByGender("Female");

//        List<Patient> patient = patientRepository.findByBornAfter(LocalDate.of(2000, 1, 15));
//        for(Patient p : patient){
//            System.out.println(p);
//        }

//        List<Object[]> genderList = patientRepository.countEachGenderType();
//        for(Object[] obj : genderList){
//            System.out.println("Gender = " + obj[0] + " " + obj[1]);
//        }

//        int rowsUpdate = patientRepository.updateNameWithId("Madhav", 4L);
//        System.out.println(rowsUpdate);

        List<GenderResponseEntity> genderList = patientRepository.countGenderType();
        for(GenderResponseEntity rsp : genderList){
            System.out.println(rsp);
        }

    }
}
