package com.enrollment_service.dto;

import Lombok.Data;
import Lombok.Builder;
import Lombok.AllArgsConstructor;
import Lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentResponse{

    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date enrollmentDate;
}
