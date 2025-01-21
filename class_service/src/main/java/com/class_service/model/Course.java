package com.class_service.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Course {

    private Integer id;
    private String name;
    private String code;
    private Double credit;
    private String description;

}
