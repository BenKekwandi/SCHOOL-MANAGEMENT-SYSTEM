package com.teacher_service.controller;


import com.teacher_service.dto.TeacherRequest;
import com.teacher_service.dto.TeacherResponse;
import com.teacher_service.model.Teacher;
import com.teacher_service.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/teacher")
public class TeacherController{

    private final TeacherService teacherService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherResponse> index(){
       return teacherService.getAllTeachers();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     teacherService.getteacher();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher store(@RequestBody TeacherRequest teacherRequest){
        return teacherService.createTeacher(teacherRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody TeacherRequest teacherRequest){
        teacherService.editTeacher(teacherRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        teacherService.deleteTeacher();
    }

}