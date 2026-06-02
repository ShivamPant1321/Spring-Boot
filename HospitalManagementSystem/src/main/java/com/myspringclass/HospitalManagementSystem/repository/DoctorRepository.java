package com.myspringclass.HospitalManagementSystem.repository;

import com.myspringclass.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}