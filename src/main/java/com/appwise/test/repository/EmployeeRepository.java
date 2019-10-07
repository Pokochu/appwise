package com.appwise.test.repository;

import com.appwise.test.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("SELECT e FROM Employee e LEFT JOIN e.company q WHERE q.id = ?1")
    List<Employee> findEmployeesByCompanyID(long companyID);
}
