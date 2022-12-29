package com.springreactive.springreactivemongodbcrud.service;

import com.springreactive.springreactivemongodbcrud.entity.Department;
import com.springreactive.springreactivemongodbcrud.repository.DepartmentReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentReactiveRepository departmentRepository;

    public Mono<Department> saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
