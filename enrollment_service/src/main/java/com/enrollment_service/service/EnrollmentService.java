package com.enrollment_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enrollment_service.dto.EnrollmentRequest;
import com.enrollment_service.dto.EnrollmentResponse;
import com.enrollment_service.model.Enrollment;
import com.enrollment_service.repository.EnrollmentRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;

    public List<EnrollmentResponse> getAllEnrollments(){

        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream().map(this::mapToEnrollmentResponse).toList();
        
    }

    public void getEnrollment(){

    }


    public Enrollment createEnrollment(EnrollmentRequest request){
        Enrollment enrollment = Enrollment.builder()
            .studentId(request.getStudentId())
            .classId(request.getClassId())
            .enrollmentDate(request.getEnrollmentDate())
            .build();
        enrollmentRepository.save(enrollment);
        return enrollment;
    }

    public void editEnrollment(EnrollmentRequest request){

    }

    public void deleteEnrollment(){
        
    }

    public EnrollmentResponse mapToEnrollmentResponse(Enrollment enrollment){
        return EnrollmentResponse.builder()
        .id(enrollment.getId())
        .studentId(enrollment.getStudentId())
        .classId(enrollment.getClassId())
        .enrollmentDate(enrollment.getEnrollmentDate())
        .build();
    }
}