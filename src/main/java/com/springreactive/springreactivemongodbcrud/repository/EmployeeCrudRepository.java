package com.springreactive.springreactivemongodbcrud.repository;

import com.springreactive.springreactivemongodbcrud.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends MongoRepository<Employee, String> {
}
