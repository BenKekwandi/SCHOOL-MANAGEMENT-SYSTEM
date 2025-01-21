package com.enrollment_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrollment_service.model.Enrollment;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
    List<Enrollment> findByClassId(Integer classId);
}