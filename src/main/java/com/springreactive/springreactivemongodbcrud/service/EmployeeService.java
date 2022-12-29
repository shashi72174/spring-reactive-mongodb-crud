package com.springreactive.springreactivemongodbcrud.service;

import com.springreactive.springreactivemongodbcrud.dto.EmployeeDTO;
import com.springreactive.springreactivemongodbcrud.entity.Department;
import com.springreactive.springreactivemongodbcrud.entity.Employee;
import com.springreactive.springreactivemongodbcrud.repository.DepartmentReactiveRepository;
import com.springreactive.springreactivemongodbcrud.repository.EmployeeRepository;
import com.springreactive.springreactivemongodbcrud.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentReactiveRepository departmentRepository;

    public Mono<Employee> saveEmployee(Employee employee) {
        /*Mono<Flux<Department>> map = employee.map(employee1 -> employee1.getDepartments().flatMap(department -> {
            return departmentRepository.findByDepartmentName(department.getDepartmentName());
        }));*/
        return employeeRepository.insert(employee);

    }


    public Mono<Employee> updateEmployee(Mono<EmployeeDTO> employee, String id) {
        return employeeRepository.findById(id)
                .flatMap(employee1 -> employee.map(AppUtils::convertEmployeeDTO).doOnNext(employee2 ->  employee2.setId(id))).flatMap(employeeRepository::save);
    }
}
