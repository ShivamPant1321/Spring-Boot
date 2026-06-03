package com.myspringclass.HospitalManagementSystem;

import com.myspringclass.HospitalManagementSystem.entity.Appointment;
import com.myspringclass.HospitalManagementSystem.entity.Insurance;
import com.myspringclass.HospitalManagementSystem.entity.Patient;
import com.myspringclass.HospitalManagementSystem.service.AppointmentService;
import com.myspringclass.HospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void insuranceTest(){
        Insurance insurance = Insurance.builder().policyNumber("HDFC_1234").provider("HDFC").validUntil(LocalDate.of(2030, 11, 23)).build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.disassociateInsurancePatient(patient.getId());
        System.out.println(newPatient);
    }

    @Test
    public void appointmentTest() {
        Appointment appointment = Appointment.builder().appointmentTime(LocalDateTime.of(2026, 06, 02, 17, 8, 32)).reason("Cancer").build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 1L);
        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reassignAppointment(newAppointment.getId(), 3L);
        System.out.println(updatedAppointment);
    }
}
