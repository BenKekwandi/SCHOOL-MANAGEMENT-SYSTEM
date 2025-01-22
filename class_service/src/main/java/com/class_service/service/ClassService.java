package com.class_service.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.text.ParseException;


import org.springframework.stereotype.Service;

import com.class_service.dto.ClassRequest;
import com.class_service.dto.ClassResponse;
import com.class_service.model.ClassModel;
import com.class_service.model.Enrollment;
import com.class_service.model.Student;
import com.class_service.model.Course;
import com.class_service.model.Teacher;
import com.class_service.repository.ClassRepository;
import com.class_service.client.CourseClient;
import com.class_service.client.EnrollmentClient;
import com.class_service.client.TeacherClient;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClassService{

    private final ClassRepository classRepository;

    private final EnrollmentClient enrollmentClient;
    private final CourseClient courseClient;
    private final TeacherClient teacherClient;

    public List<ClassResponse> getAllClasses(){
        List<ClassModel> classes = classRepository.findAll();
        return classes.stream().map(this::mapToClassResponse).toList();
        
    }

    // public void getClass(){

    // }


    public ClassModel createClass(ClassRequest request){
        ClassModel classItem = ClassModel.builder()
            .status(request.getStatus())
            .teacherId(request.getTeacherId())
            .courseId(request.getCourseId())
            .openingDate(request.getOpeningDate())
            .closingDate(request.getClosingDate())
            .build();
        classRepository.save(classItem);
        return classItem;
    }

    public void editClass(ClassRequest request){

    }

    public void deleteClass(){
        
    }

    public ClassResponse mapToClassResponse(ClassModel classModel){
        List<Map<String, Object>> enrollmentsMaps = enrollmentClient.getEnrollmentByClassId(classModel.getId());
        Map<String, Object> teacherMap = teacherClient.getTeacherById(classModel.getTeacherId());
        Map<String, Object> courseMap = courseClient.getCourseById(classModel.getCourseId());
        List<Enrollment> enrollments = mapToEnrollments(enrollmentsMaps);
        Teacher teacher = mapToTeacher(teacherMap);
        Course course = mapToCourse(courseMap);

        return ClassResponse.builder()
        .id(classModel.getId())
        .status(classModel.getStatus())
        .teacher(teacher)
        .enrollments(enrollments)
        .course(course)
        .openingDate(classModel.getOpeningDate())
        .closingDate(classModel.getClosingDate())
        .build();
    }

    public Course mapToCourse(Map<String, Object> courseMap){
        return Course.builder()
        .id((Integer)courseMap.get("id"))
        .name((String)courseMap.get("name"))
        .credit((Double)courseMap.get("credit"))
        .code((String)courseMap.get("code"))
        .build();
    }

    public Teacher mapToTeacher(Map<String, Object> teacherMap){
        return Teacher.builder()
        .id((Integer)teacherMap.get("id"))
        .name((String)teacherMap.get("name"))
        .surname((String)teacherMap.get("surname"))
        .email((String)teacherMap.get("email"))
        .build();
    }

    public List<Enrollment> mapToEnrollments(List<Map<String, Object>> enrollmentsMaps){
        List<Enrollment> enrollments = new ArrayList<>();
        for(Map<String, Object>enrollmentsMap: enrollmentsMaps){
            enrollments.add(
                Enrollment.builder()
                .studentId((Integer)enrollmentsMap.get("studentId"))
                .enrollmentDate(parseDate((String) enrollmentsMap.get("enrollmentDate")))
                .student(mapToStudent((Map<String, Object>) enrollmentsMap.get("student")))
                .build()
            );
        }
        return enrollments;
    }

    private Student mapToStudent(Map<String, Object> studentMap) {
        return Student.builder()
            .id((Integer) studentMap.get("id"))
            .username((String) studentMap.get("username"))
            .name((String) studentMap.get("name"))
            .surname((String) studentMap.get("surname"))
            .email((String) studentMap.get("email"))
            .build();
    }

      private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return new java.sql.Date(dateFormat.parse(dateStr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + dateStr, e);
        }
    }
}