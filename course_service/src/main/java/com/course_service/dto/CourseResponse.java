package com.course_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data


public class CourseResponse {
    private Integer id;
    private String name;
    private String code;
    private Double credit;
    private String description;
}
