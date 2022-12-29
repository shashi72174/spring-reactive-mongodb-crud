package com.springreactive.springreactivemongodbcrud.controller;

import com.springreactive.springreactivemongodbcrud.dto.EmployeeDTO;
import com.springreactive.springreactivemongodbcrud.entity.Employee;
import com.springreactive.springreactivemongodbcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee-services")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Mono<Employee> saveEmployee(@RequestBody Employee employee){
        System.out.println("hi this is added to check something");
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Mono<Employee> updateEmployee(@RequestBody Mono<EmployeeDTO> employee, @PathVariable String id) {
        System.out.println("hi this is added to check something 2");
        return employeeService.updateEmployee(employee, id);
    }


}
