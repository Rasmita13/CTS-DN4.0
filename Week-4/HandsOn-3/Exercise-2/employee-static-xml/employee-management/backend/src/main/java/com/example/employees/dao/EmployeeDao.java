package com.example.employees.dao;

import com.example.employees.model.Employee;
import java.util.ArrayList;

public class EmployeeDao {

    public static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao(ArrayList<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
