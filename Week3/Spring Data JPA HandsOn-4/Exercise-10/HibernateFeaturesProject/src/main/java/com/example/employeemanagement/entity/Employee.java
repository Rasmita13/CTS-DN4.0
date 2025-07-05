package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "employee")
@DynamicInsert
@DynamicUpdate
@BatchSize(size = 25)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double salary;

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
