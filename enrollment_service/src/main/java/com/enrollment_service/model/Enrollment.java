package com.enrollment_service.model;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Table(name="enrollments")
@Entity
@Builder
@Data
public class Enrollment {
    @Id
    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date enrollmentDate;
}
