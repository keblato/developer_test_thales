package com.thaleskevin.developer_test.controller;

import com.thaleskevin.developer_test.model.Employee;
import com.thaleskevin.developer_test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getAllEmployees(@PathVariable String id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Employee[]> getEmployeeById() {
        return new ResponseEntity<Employee[]>(employeeService.getEmployees(), HttpStatus.OK);
    }

}
