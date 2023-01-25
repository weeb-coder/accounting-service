package com.microservices.accountingservice.proxy;

import com.microservices.accountingservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "employee-service")
public interface EmployeeServiceProxy {

    @GetMapping("/employees/{empId}")
    Optional<Employee> getEmployeeById(@PathVariable("empId") String id);

}
