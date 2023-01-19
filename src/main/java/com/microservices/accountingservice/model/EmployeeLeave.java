package com.microservices.accountingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Employee.EmployeeBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeLeave {

    private int count;
    private int daysInMonth;

    public EmployeeLeave() {}

    public EmployeeLeave(EmployeeLeaveBuilder builder) {
        this.count = builder.count;
        this.daysInMonth = builder.daysInMonth;
    }

    public int getCount() {
        return count;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    private static class EmployeeLeaveBuilder {
        protected int count;
        protected int daysInMonth;

        public EmployeeLeaveBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public EmployeeLeaveBuilder setDaysInMonth(int daysInMonth) {
            this.daysInMonth = daysInMonth;
            return this;
        }

        public EmployeeLeave build() {
            return new EmployeeLeave(this);
        }
    }
}
