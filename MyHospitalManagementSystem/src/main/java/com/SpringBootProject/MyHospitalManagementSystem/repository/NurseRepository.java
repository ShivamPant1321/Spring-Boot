package com.SpringBootProject.MyHospitalManagementSystem.repository;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
