package com.springreactive.springreactivemongodbcrud.util;

import com.springreactive.springreactivemongodbcrud.dto.EmployeeDTO;
import com.springreactive.springreactivemongodbcrud.dto.ProductDTO;
import com.springreactive.springreactivemongodbcrud.entity.Employee;
import com.springreactive.springreactivemongodbcrud.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static ProductDTO convertProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        return productDTO;
    }

    public static Product convertProductDTO(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        return product;
    }


    public static Employee convertEmployeeDTO(EmployeeDTO employeeDTO) {
        System.out.println("convertEmployeeDTO");
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeDTO,emp);
        return emp;
    }

    public static EmployeeDTO convertEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);
        return employeeDTO;
    }
}
