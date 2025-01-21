package com.enrollment_service.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "student-service", url = "http://localhost:3003/")
public interface StudentClient {
    @GetMapping("/api/student")
    Map<String, Object> getStudentById(@PathVariable Integer id);
}



