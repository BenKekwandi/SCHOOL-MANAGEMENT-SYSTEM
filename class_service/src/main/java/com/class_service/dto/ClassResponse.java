package com.class_service.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.class_service.model.Enrollment;
import com.class_service.model.Teacher;
import com.class_service.model.Course;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClassResponse{
    private Integer id;
    private Boolean status;
    private Course course;
    private Teacher teacher;
    private List<Enrollment> enrollments;
    private Date openingDate;
    private Date closingDate;

}
