package com.class_service.model;

import java.util.Date;

import Lombok.Data;
import Lombok.Builder;
import Jakarta.persistence.Table;
import Jakarta.persistence.Entity;
import Jakarta.persistence.Id;

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
