package com.springreactive.springreactivemongodbcrud.repository;

import com.springreactive.springreactivemongodbcrud.entity.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DepartmentReactiveRepository extends ReactiveMongoRepository<Department, String> {

    Mono<Department> findByDepartmentName(String departmentName);
}
