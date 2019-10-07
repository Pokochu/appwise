package com.appwise.test.services;

import com.appwise.test.AlreadyExistingEmployeeException;
import com.appwise.test.model.Employee;
import com.appwise.test.repository.EmployeeRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repository;

    public void saveOrUpdate(Employee employee) throws AlreadyExistingEmployeeException {
        try {
            repository.save(employee);
        } catch (ConstraintViolationException exception) {
            throw new AlreadyExistingEmployeeException("EmployeeID for " + employee.getFirstName() + " " + employee.getSurname() + "is already exist in the database!");
        }
    }

    public List<Employee> getEmployeesByCompanyID(long companyID) {
        return repository.findEmployeesByCompanyID(companyID);
    }

    public List<Employee> getAllEmployees() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
