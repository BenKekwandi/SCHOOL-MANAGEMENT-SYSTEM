package com.student_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student_service.dto.StudentRequest;
import com.student_service.dto.StudentResponse;
import com.student_service.model.Student;
import com.student_service.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class StudentService{

    private final StudentRepository studentRepository;

    public List<StudentResponse> getAllStudents(){

        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapToStudentResponse).toList();
        
    }

    public void getStudent(){

    }


    public Student createStudent(StudentRequest request){
        Student student = Student.builder()
            .name(request.getName())
            .surname(request.getSurname())
            .email(request.getEmail())
            .build();
        studentRepository.save(student);
        return student;
    }

    public void editStudent(StudentRequest request){

    }

    public void deleteStudent(){
        
    }

    public StudentResponse mapToStudentResponse(Student student){
        return StudentResponse.builder()
        .id(student.getId())
        .name(student.getName())
        .surname(student.getSurname())
        .email(student.getEmail())
        .build();
    }
}