package com.course_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_service.dto.CourseRequest;
import com.course_service.dto.CourseResponse;
import com.course_service.model.Course;
import com.course_service.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class CourseService{

    private final CourseRepository courseRepository;

    public List<CourseResponse> getAllCourses(){

        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::mapToCourseResponse).toList();
        
    }

    public void getcourse(){

    }


    public Course createCourse(CourseRequest request){
        Course course = Course.builder()
            .name(request.getName())
            .code(request.getCode())
            .description(request.getDescription())
            .credit(request.getCredit())
            .build();
        courseRepository.save(course);
        return course;
    }

    public void editCourse(CourseRequest request){

    }

    public void deleteCourse(){
        
    }

    public CourseResponse mapToCourseResponse(Course course){
        return CourseResponse.builder()
        .name(course.getName())
        .code(course.getCode())
        .description(course.getDescription())
        .credit(course.getCredit())
        .build();
    }
}