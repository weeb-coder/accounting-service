package com.microservices.accountingservice.controller;

import com.microservices.accountingservice.model.EmployeeSalary;
import com.microservices.accountingservice.model.Salary;
import com.microservices.accountingservice.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountingController {

    @Autowired
    AccountingService service;

    @PostMapping("/calculateSalary")
    public Salary calcSalary(@RequestBody EmployeeSalary emp) {
        return service.calcSalary(emp);
    }

}
