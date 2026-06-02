package com.myspringclass.HospitalManagementSystem.repository;

import com.myspringclass.HospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}