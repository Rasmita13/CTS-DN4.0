package com.example.employees.service;

import com.example.employees.dao.DepartmentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional(readOnly = true)
    public List<String> getAllDepartments() {
        System.out.println("DepartmentService: Fetching departments...");
        return departmentDao.getAllDepartments();
    }
}

