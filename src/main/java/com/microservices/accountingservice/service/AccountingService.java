package com.microservices.accountingservice.service;

import com.microservices.accountingservice.EmployeeServiceProxy;
import com.microservices.accountingservice.WorkhourServiceProxy;
import com.microservices.accountingservice.model.Employee;
import com.microservices.accountingservice.model.EmployeeSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountingService {

    @Autowired
    EmployeeServiceProxy employeeServiceProxy;

    @Autowired
    WorkhourServiceProxy workhourServiceProxy;

    public String calcSalary(EmployeeSalary emp) {
        Optional<Employee> employee = employeeServiceProxy.getEmployeeById(emp.getEmpId());
        int baseSalary = employee.orElseThrow().getBaseSalary();
        int employeeLeaveCount = workhourServiceProxy.getEmployeeLeaveCount(emp.getEmpId());
        int daysInMonth = workhourServiceProxy.getDaysInMonth(emp.getEmpId());
        int salary = baseSalary * (daysInMonth - employeeLeaveCount) / daysInMonth;
        System.out.println("-----------------------------------");
        System.out.println("Emp : " + emp);
        System.out.println(baseSalary);
        System.out.println(employeeLeaveCount);
        System.out.println(daysInMonth);
        System.out.println("-----------------------------------");
        System.out.println(salary);
        System.out.println("-----------------------------------");
        return "Employee salary calculated.";
    }

    public String calcEmployeeLeave(EmployeeSalary emp) {
        return "Employee leave calculated.";
    }
}
