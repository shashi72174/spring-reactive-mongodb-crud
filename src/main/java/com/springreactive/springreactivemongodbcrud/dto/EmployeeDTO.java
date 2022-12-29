package com.springreactive.springreactivemongodbcrud.dto;

import com.springreactive.springreactivemongodbcrud.entity.Address;
import com.springreactive.springreactivemongodbcrud.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String employeeName;
    private Double salary;
    private Flux<Department> departments;
    private Address address;
}
