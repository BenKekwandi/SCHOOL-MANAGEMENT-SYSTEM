package com.class_service.model;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Table(name="classes")
@Entity
@Builder
@Data
public class Class {
    @Id
    private Integer id;
    private Boolean status;
    private Integer courseId;
    private Integer teacherId;
    private Date openingDate;
    private Date closingDate;
}
