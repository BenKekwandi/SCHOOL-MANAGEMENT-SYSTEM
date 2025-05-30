package com.class_service.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Teacher {
    
    private Integer id;
    private String name;
    private String surname;
    private String email;

}
