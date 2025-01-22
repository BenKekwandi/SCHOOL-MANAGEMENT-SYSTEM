package com.class_service.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "course-service", url = "http://localhost:3004")
public interface CourseClient {
    @GetMapping("/api/course/{id}")
    Map<String, Object> getCourseById(@PathVariable Integer id);
}



