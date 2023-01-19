package com.microservices.accountingservice.proxy;

import com.microservices.accountingservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "employee-service", url = "localhost:8000/employees")
public interface EmployeeServiceProxy {

    @GetMapping("/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable("empId") String id);

}
