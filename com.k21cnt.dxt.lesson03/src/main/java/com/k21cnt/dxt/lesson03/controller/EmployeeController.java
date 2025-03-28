package com.k21cnt.dxt.lesson03.controller;


import com.k21cnt.dxt.lesson03.dto.request.EmployeeRequest;
import com.k21cnt.dxt.lesson03.mapper.EmployeeMapper;
import com.k21cnt.dxt.lesson03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeService employeeService ;

    @GetMapping("")
    public List<EmployeeRequest> getAllEmployeeRequestList(){
        return employeeService.getEmployeeList();
    }

    @PostMapping("/add")
    public void employeeAdd(@RequestBody EmployeeRequest employeeRequest){
        employeeService.employeeAdd(employeeRequest);
    }
}