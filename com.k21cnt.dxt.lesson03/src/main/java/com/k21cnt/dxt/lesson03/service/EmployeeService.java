package com.k21cnt.dxt.lesson03.service;

import com.k21cnt.dxt.lesson03.dto.request.EmployeeRequest;
import com.k21cnt.dxt.lesson03.entity.Employee;
import com.k21cnt.dxt.lesson03.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    private List<Employee> employeeList;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
        employeeList =new ArrayList<Employee>();
        employeeList.add(new Employee(1,"Nguyễn Văn ","Bình",12.222f,"binh@gmail.com"));
        employeeList.add(new Employee(2,"Nguyễn Thị ","Bình",20.2312f,"binhthi@gmail.com"));
    }
    public List<EmployeeRequest> getEmployeeList() {
        return employeeList.stream()
                .map(emp-> employeeMapper.toEmployeeRequest(emp)).collect(Collectors.toList());
    }
    public void employeeAdd(EmployeeRequest employeeRequest) {
        employeeMapper = new EmployeeMapper();
        Employee employee = employeeMapper.toEmployee(employeeRequest);
        employeeList.add(employee);
    }
}