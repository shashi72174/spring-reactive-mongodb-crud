package com.springreactive.springreactivemongodbcrud.controller;

import com.springreactive.springreactivemongodbcrud.entity.Department;
import com.springreactive.springreactivemongodbcrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Mono<Department> saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

}
