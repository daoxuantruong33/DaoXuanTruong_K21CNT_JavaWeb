package com.k21cnt.dxt.lesson03.mapper;


import com.k21cnt.dxt.lesson03.dto.request.EmployeeRequest;
import com.k21cnt.dxt.lesson03.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setId(employeeRequest.getId());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setSalary(0);
        return employee;
    }

    public EmployeeRequest toEmployeeRequest(Employee employee) {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setId(employee.getId());
        employeeRequest.setFirstName(employee.getFirstName());
        employeeRequest.setLastName(employee.getLastName());
        employeeRequest.setEmail(employee.getEmail());
        return employeeRequest;
    }
}