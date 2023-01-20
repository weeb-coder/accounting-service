package com.microservices.accountingservice.proxy;

import com.microservices.accountingservice.model.Leave;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "workhour-service")
public interface WorkhourServiceProxy {

    @GetMapping("/{empId}")
    Leave getEmployeeLeaveDetails(@PathVariable String empId);

}
