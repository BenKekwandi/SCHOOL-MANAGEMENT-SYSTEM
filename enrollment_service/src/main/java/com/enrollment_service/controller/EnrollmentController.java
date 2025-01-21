package com.enrollment_service.controller;

import com.enrollment_service.dto.EnrollmentRequest;
import com.enrollment_service.dto.EnrollmentResponse;
import com.enrollment_service.model.Enrollment;
import com.enrollment_service.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/enrollment")
public class EnrollmentController{

    private final EnrollmentService enrollmentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentResponse> index(){
       return enrollmentService.getAllEnrollments();
    }

    @GetMapping("class")
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentResponse> getByClass(@RequestParam Integer classId){
        return enrollmentService.getAllEnrollmentsByClassId(classId);
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     enrollmentService.getEnrollment();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment store(@RequestBody EnrollmentRequest enrollmentRequest){
        return enrollmentService.createEnrollment(enrollmentRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody EnrollmentRequest enrollmentRequest){
        enrollmentService.editEnrollment(enrollmentRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        enrollmentService.deleteEnrollment();
    }

}