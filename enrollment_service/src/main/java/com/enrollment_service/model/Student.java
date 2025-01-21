package com.enrollment_service.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {
    private Integer id;
    private String username;
    private String name;
    private String surname;
    private String email;
}
