package com.microservices.accountingservice.service;

import com.microservices.accountingservice.model.*;
import com.microservices.accountingservice.proxy.EmployeeServiceProxy;
import com.microservices.accountingservice.proxy.WorkhourServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountingService {

    private static final Logger log = LoggerFactory.getLogger(AccountingService.class);

    @Autowired
    EmployeeServiceProxy employeeServiceProxy;

    @Autowired
    WorkhourServiceProxy workhourServiceProxy;

//    https://stackoverflow.com/questions/55394469/how-to-share-java-models-between-microservices-in-microservice-architecture

    public Salary calcSalary(EmployeeSalary emp) {
        Optional<Employee> employee = employeeServiceProxy.getEmployeeById(emp.getEmpId());
//        Leave empLeave = workhourServiceProxy.getEmployeeLeaveDetails(emp.getEmpId());
        Leave empLeave = workhourServiceProxy.getEmployeeLeaveDetail(emp);
        log.info("YearMonth :: " + emp.getYearMonth());
        log.info(employee.toString());
        log.info(empLeave.toString());

        int baseSalary = employee.orElseThrow().getBaseSalary();
        int employeeLeaveCount = empLeave.getCount();
        int daysInMonth = empLeave.getDaysInMonth();
        int salary = baseSalary * (daysInMonth - employeeLeaveCount) / daysInMonth;

        return new Salary
                .SalaryBuilder()
                .setYearMonth(emp.getYearMonth())
                .setAmount(salary)
                .build();
    }

}
