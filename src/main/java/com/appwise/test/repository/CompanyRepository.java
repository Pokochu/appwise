package com.appwise.test.repository;

import com.appwise.test.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE c.name = ?1")
    Company findCompanyByName(String companyname);
}
