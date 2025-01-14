package com.teacher_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data


public class TeacherRequest {
    public Integer id;
    public String username;
    public String name;
    public String surname;
    public String email;
    public String password;
}
