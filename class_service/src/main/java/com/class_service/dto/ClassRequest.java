package com.class_service.dto;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {
    private Integer id;
    private Boolean status;
    private Integer courseId;
    private Integer teacherId;
    private Date openingDate;
    private Date closingDate;
}
