package com.enrollment_service.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enrollment_service.client.StudentClient;
import com.enrollment_service.dto.EnrollmentRequest;
import com.enrollment_service.dto.EnrollmentResponse;
import com.enrollment_service.model.Enrollment;
import com.enrollment_service.model.Student;
import com.enrollment_service.repository.EnrollmentRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;
    private final StudentClient studentClient;

    public List<EnrollmentResponse> getAllEnrollments(){

        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream().map(this::mapToEnrollmentResponse).toList();
        
    }

    public List<EnrollmentResponse> getAllEnrollmentsByClassId(Integer classId){
        List<Enrollment> enrollments = enrollmentRepository.findByClassId(classId);
        return enrollments.stream().map(this::mapToEnrollmentResponse).toList();
    }

    public EnrollmentResponse getEnrollment(Integer enrollmentId){
        Optional<Enrollment> enrollment= enrollmentRepository.findById(enrollmentId);
        return mapToEnrollmentResponse(enrollment.orElse(null));
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

        Map<String, Object> studentMap = studentClient.getStudentById(enrollment.getStudentId());

        Student student = Student.builder()
        .id((Integer) studentMap.get("id"))
        .name((String) studentMap.get("name"))
        .surname((String) studentMap.get("surname"))
        .email((String) studentMap.get("email"))
        .build();

        return EnrollmentResponse.builder()
        .id(enrollment.getId())
        // .studentId(enrollment.getStudentId())
        .student(student)
        .classId(enrollment.getClassId())
        .enrollmentDate(enrollment.getEnrollmentDate())
        .build();
    }
}