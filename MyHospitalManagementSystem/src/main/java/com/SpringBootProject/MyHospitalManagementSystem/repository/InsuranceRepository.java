package com.SpringBootProject.MyHospitalManagementSystem.repository;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
