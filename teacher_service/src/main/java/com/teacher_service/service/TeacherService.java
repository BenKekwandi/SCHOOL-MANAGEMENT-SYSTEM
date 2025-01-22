package com.teacher_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teacher_service.dto.TeacherRequest;
import com.teacher_service.dto.TeacherResponse;
import com.teacher_service.model.Teacher;
import com.teacher_service.repository.TeacherRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class TeacherService{

    private final TeacherRepository teacherRepository;

    public List<TeacherResponse> getAllTeachers(){

        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(this::mapToTeacherResponse).toList();
        
    }

    public Teacher getTeacher(Integer id){
        Optional<Teacher> teacherOpt = teacherRepository.findById(id);
        return teacherOpt.get();
    }


    public Teacher createTeacher(TeacherRequest request){
        Teacher teacher = Teacher.builder()
            .name(request.getName())
            .surname(request.getSurname())
            .email(request.getEmail())
            .build();
        teacherRepository.save(teacher);
        return teacher;
    }

    public void editTeacher(TeacherRequest request){

    }

    public void deleteTeacher(){
        
    }

    public TeacherResponse mapToTeacherResponse(Teacher teacher){
        return TeacherResponse.builder()
        .id(teacher.getId())
        .name(teacher.getName())
        .surname(teacher.getSurname())
        .email(teacher.getEmail())
        .build();
    }
}