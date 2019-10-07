package com.appwise.test.controllers;

import com.appwise.test.model.Company;
import com.appwise.test.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    private List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/companies")
    private long saveCompany(@RequestBody Company company) {
        companyService.saveOrUpdate(company);
        return company.getId();
    }

    @GetMapping("/companies/{id}")
    private Company getCompany(@PathVariable("id") long id) {
        return companyService.getCompanybyID(id);
    }

    @GetMapping("/companies/byName/{companyName}")
    private Company getCompanyByName(@PathVariable("companyName") String companyName) {
        return companyService.getCompanyByName(companyName);
    }
}
