package com.course_service.controller;

import com.course_service.dto.CourseRequest;
import com.course_service.dto.CourseResponse;
import com.course_service.model.Course;
import com.course_service.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/course")
public class CourseController{

    private final CourseService courseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> index(){
       return courseService.getAllCourses();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     courseService.getcourse();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course store(@RequestBody CourseRequest courseRequest){
        return courseService.createCourse(courseRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody CourseRequest courseRequest){
        courseService.editCourse(courseRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        courseService.deleteCourse();
    }

}