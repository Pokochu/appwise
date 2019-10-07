package com.appwise.test.controllers;

import com.appwise.test.AlreadyExistingEmployeeException;
import com.appwise.test.model.Employee;
import com.appwise.test.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    private List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    private String saveEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveOrUpdate(employee);
        } catch (AlreadyExistingEmployeeException e) {
            LOGGER.error(e.getMessage());
            return e.getMessage();
        }
        return employee.toString();
    }

    @GetMapping("employee/{companyID}")
    private List<Employee> getEmployeesByCompanyID(@PathVariable("companyID") long companyID) {
        return employeeService.getEmployeesByCompanyID(companyID);
    }
}
