package com.example.employees.dao;
import java.util.List;
public class DepartmentDao {

    public static List<String> DEPARTMENT_LIST;

    public DepartmentDao(List<String> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public List<String> getAllDepartments() {
        System.out.println("DepartmentDao: Returning department list...");
        return DEPARTMENT_LIST;
    }
}

