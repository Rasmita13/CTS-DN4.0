package com.example.employeemanagement.employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;

    // Constructors, getters, setters
    public Employee() {}
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getSalary() { return salary; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(Double salary) { this.salary = salary; }
}
