package com.enrollment_service.model;

import Lombok.Data;
import Lombok.Builder;
import Jakarta.persistence.Table;
import Jakarta.persistence.Entity;
import Jakarta.persistence.Id;

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
