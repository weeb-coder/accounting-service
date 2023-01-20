package com.microservices.accountingservice.service;

import com.microservices.accountingservice.model.*;
import com.microservices.accountingservice.proxy.EmployeeServiceProxy;
import com.microservices.accountingservice.proxy.WorkhourServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountingService {

    @Autowired
    EmployeeServiceProxy employeeServiceProxy;

    @Autowired
    WorkhourServiceProxy workhourServiceProxy;

    public Salary calcSalary(EmployeeSalary emp) {
        Optional<Employee> employee = employeeServiceProxy.getEmployeeById(emp.getEmpId());
        Leave empLeave = workhourServiceProxy.getEmployeeLeaveDetails(emp.getEmpId());
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
