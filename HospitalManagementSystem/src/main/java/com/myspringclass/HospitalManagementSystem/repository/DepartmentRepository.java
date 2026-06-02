package com.myspringclass.HospitalManagementSystem.repository;

import com.myspringclass.HospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}