package com.example.employeemanagement.dto;

public class EmployeeDTO {
    private String name;
    private Double salary;

    public EmployeeDTO(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }
}
