package com.myspringclass.HospitalManagementSystem.service;


import com.myspringclass.HospitalManagementSystem.entity.Appointment;
import com.myspringclass.HospitalManagementSystem.entity.Doctor;
import com.myspringclass.HospitalManagementSystem.entity.Patient;
import com.myspringclass.HospitalManagementSystem.repository.AppointmentRepository;
import com.myspringclass.HospitalManagementSystem.repository.DoctorRepository;
import com.myspringclass.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null){
            throw new IllegalArgumentException("Appointment already exists");
        }else{
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);

            patient.getAppointments().add(appointment); // to maintain bidirectional consistency

            return appointmentRepository.save(appointment);
        }
    }

    @Transactional
    public Appointment reassignAppointment(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically update the appointment as it is dirty

        doctor.getAppointments().add(appointment); // this is used to maintain consistency

        return appointment;
    }
}
