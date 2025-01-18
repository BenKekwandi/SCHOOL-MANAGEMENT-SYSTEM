package com.class_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.class_service.dto.ClassRequest;
import com.class_service.dto.ClassResponse;
import com.class_service.model.Class;
import com.class_service.repository.ClassRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClassService{

    private final ClassRepository classRepository;

    public List<ClassResponse> getAllClasses(){

        List<Class> classes = classRepository.findAll();
        return Classes.stream().map(this::mapToClassResponse).toList();
        
    }

    // public void getClass(){

    // }


    public Class createClass(ClassRequest request){
        Class classItem = Class.builder()
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

    public ClassResponse mapToClassResponse(Class classModel){
        return ClassResponse.builder()
        .id(classModel.getId())
        .status(classModel.getStatus())
        .teacherId(classModel.getTeacherId())
        .courseId(classModel.getCourseId())
        .openingDate(classModel.getOpeningDate())
        .closingDate(classModel.getClosingDate())
        .build();
    }
}