package com.appwise.test.services;

import com.appwise.test.model.Company;
import com.appwise.test.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public void saveOrUpdate(Company company) {
        repository.save(company);
    }

    public List<Company> getAllCompanies() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Company getCompanybyID(long id) {
        return repository.findById(id).get();
    }

    public Company getCompanyByName(String name) {
        return repository.findCompanyByName(name);
    }
}
