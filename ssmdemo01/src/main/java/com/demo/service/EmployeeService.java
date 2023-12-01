package com.demo.service;

import com.demo.pojo.AddEmployee;
import com.demo.pojo.ModifyEmployee;

import java.util.List;

public interface EmployeeService {
    Integer addEmployee(AddEmployee addEmployee);
    Integer modifyEmployee(ModifyEmployee modifyEmployee);
    Integer deleteEmployee(Integer id);
    List<AddEmployee> getAllEmployee();
    AddEmployee getByEmployeeId(Integer id);
}
