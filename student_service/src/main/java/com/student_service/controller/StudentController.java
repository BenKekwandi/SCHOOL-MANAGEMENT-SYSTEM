package com.student_service.controller;

import com.student_service.dto.StudentRequest;
import com.student_service.dto.StudentResponse;
import com.student_service.model.Student;
import com.student_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/student")
public class StudentController{

    private final StudentService studentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> index(){
       return studentService.getAllStudents();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     studentService.getstudent();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student store(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody StudentRequest studentRequest){
        studentService.editStudent(studentRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        studentService.deleteStudent();
    }

}