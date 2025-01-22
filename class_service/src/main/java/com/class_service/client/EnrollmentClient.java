package com.class_service.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "student-service", url = "http://localhost:3008/")
public interface EnrollmentClient {
    @GetMapping("/api/enrollment/class/{id}")
    List<Map<String, Object>> getEnrollmentByClassId(@PathVariable Integer id);

}



