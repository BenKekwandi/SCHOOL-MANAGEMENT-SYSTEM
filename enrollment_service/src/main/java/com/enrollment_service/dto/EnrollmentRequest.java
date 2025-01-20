package com.enrollment_service.dto;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest{

    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date enrollmentDate;
}
