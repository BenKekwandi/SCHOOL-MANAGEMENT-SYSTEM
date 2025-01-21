package com.class_service.model;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Enrollment{

    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date enrollmentDate;
    private Student student;
}
