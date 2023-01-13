package com.microservices.accountingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "workhour-service", url = "localhost:8100/employeeLeave")
public interface WorkhourServiceProxy {

    @GetMapping("/getCount/{empId}")
    public int getEmployeeLeaveCount(@PathVariable String empId);

    @GetMapping("/getDaysInMonth/{empId}")
    public int getDaysInMonth(@PathVariable String empId);

}
