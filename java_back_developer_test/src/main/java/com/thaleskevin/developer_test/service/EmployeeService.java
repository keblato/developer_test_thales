package com.thaleskevin.developer_test.service;

import com.thaleskevin.developer_test.model.Employee;
import com.thaleskevin.developer_test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee getEmployeeById(String id) {
        Employee employee = employeeRepository.findOne(id);
        if (employee != null) {
            employee.setEmployeeAnnualSalary(calculateAnnualSalary(employee.getEmployeeSalary()));
        }
        return employee;
    }

    public Employee[] getEmployees() {
        Employee[] employeeList = employeeRepository.findAll();
        for (Employee employee :
                employeeList) {
            employee.setEmployeeAnnualSalary(calculateAnnualSalary(employee.getEmployeeSalary()));
        }

        return employeeList;
    }

    private Double calculateAnnualSalary(Double monthlySalary) {
        if (monthlySalary == null) {
            return null;
        }
        return monthlySalary * 12;
    }
}
