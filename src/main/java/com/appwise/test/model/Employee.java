package com.appwise.test.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
public class Employee {

    @Id
    private String employeeID;
    private String surname;
    private String firstName;
    @ManyToOne
    @JoinColumn(name = "id")
    private Company company;

    @PrePersist
    private void ensureId() {
        String name = this.surname + this.firstName;
        List<String> letters = Arrays.asList(name.toUpperCase().split(""));
        Collections.shuffle(letters);
        StringBuilder builder = new StringBuilder("");
        letters.forEach(builder::append);
        this.setEmployeeID(builder.toString());
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
