package com.SpringBootProject.MyHospitalManagementSystem.repository;

import com.SpringBootProject.MyHospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
