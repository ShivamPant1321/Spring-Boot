package com.SpringBootProject.MyHospitalManagementSystem.repository;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
