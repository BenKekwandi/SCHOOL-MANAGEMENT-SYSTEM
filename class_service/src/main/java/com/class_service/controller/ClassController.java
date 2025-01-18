package com.class_service.controller;

import com.class_service.dto.ClassRequest;
import com.class_service.dto.ClassResponse;
import com.class_service.model.Class;
import com.class_service.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/Class")
public class ClassController{

    private final ClassService classService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClassResponse> index(){
       return classService.getAllClasss();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     classService.getClass();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Class store(@RequestBody ClassRequest classRequest){
        return classService.createClass(classRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ClassRequest classRequest){
        classService.editClass(classRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        classService.deleteClass();
    }

}