package com.microservices.accountingservice.controller;

import com.microservices.accountingservice.model.EmployeeSalary;
import com.microservices.accountingservice.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {

    @Autowired
    AccountingService service;

    @PostMapping("/calculateSalary")
    public String calcSalary(@RequestBody EmployeeSalary emp) {
        return service.calcSalary(emp);
    }

    @PostMapping("/calculateEmployeeLeave")
    public String calcEmployeeLeave(@RequestBody EmployeeSalary emp) {
        return service.calcEmployeeLeave(emp);
    }
}
