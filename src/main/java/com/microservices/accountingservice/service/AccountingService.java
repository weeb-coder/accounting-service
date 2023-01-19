package com.microservices.accountingservice.service;

import com.microservices.accountingservice.model.EmployeeLeave;
import com.microservices.accountingservice.proxy.EmployeeServiceProxy;
import com.microservices.accountingservice.proxy.WorkhourServiceProxy;
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

    public int calcSalary(EmployeeSalary emp) {
        Optional<Employee> employee = employeeServiceProxy.getEmployeeById(emp.getEmpId());
        EmployeeLeave empLeave = workhourServiceProxy.getDetails(emp.getEmpId());
        int baseSalary = employee.orElseThrow().getBaseSalary();
        int employeeLeaveCount = empLeave.getCount();
        int daysInMonth = empLeave.getDaysInMonth();
        int salary = baseSalary * (daysInMonth - employeeLeaveCount) / daysInMonth;
        return salary;
    }

}
