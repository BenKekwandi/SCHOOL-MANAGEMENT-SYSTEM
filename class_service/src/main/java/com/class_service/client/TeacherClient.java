package com.class_service.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "teacher-service", url = "http://localhost:3002")
public interface TeacherClient {
    @GetMapping("/api/teacher")
    Map<String, Object> getTeacherById(@PathVariable Integer id);
}



