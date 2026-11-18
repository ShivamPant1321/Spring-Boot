package com.SpringBootProject.MyHospitalManagementSystem.repository;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointments, Long> {
}
