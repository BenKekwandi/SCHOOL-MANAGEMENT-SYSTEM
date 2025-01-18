package com.class_service.dto;

import java.util.Date;

import Lombok.Data;
import Lombok.Builder;
import Lombok.AllArgsConstructor;
import Lombok.NoArgsConstructor;

import Jakarta.persistence.Id;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassResponse{
    private Integer id;
    private Boolean status;
    private Integer courseId;
    private Integer teacherId;
    private Date openingDate;
    private Date closingDate;
}
