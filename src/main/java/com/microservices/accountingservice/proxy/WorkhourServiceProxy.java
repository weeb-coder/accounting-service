package com.microservices.accountingservice.proxy;

import com.microservices.accountingservice.model.EmployeeLeave;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "workhour-service", url = "localhost:8100/employeeLeave")
public interface WorkhourServiceProxy {

    @GetMapping("/{empId}")
    public EmployeeLeave getDetails(@PathVariable String empId);

}
