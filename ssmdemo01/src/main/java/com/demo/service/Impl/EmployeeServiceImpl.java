package com.demo.service.Impl;

import com.demo.mapper.EmployeeMapper;
import com.demo.pojo.AddEmployee;
import com.demo.pojo.ModifyEmployee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Integer addEmployee(AddEmployee addEmployee) {
        if (addEmployee.getUsername().trim() == null || addEmployee.getAge() == null ||
                addEmployee.getEmail().trim() == null) {
            throw new IllegalArgumentException("用户名，年龄，邮箱不得为空");
        }

        AddEmployee employee = employeeMapper.findByUsername(addEmployee.getUsername());
        if (employee != null) {
            throw new IllegalArgumentException("该用户已存在，请注册其他用户名");
        }

        Integer result = employeeMapper.addEmployee(addEmployee.getId(), addEmployee.getUsername(), addEmployee.getAge(),
                addEmployee.getBirthday(), addEmployee.getEmail(), addEmployee.getAddress());
        return result;
    }

    @Override
    public Integer modifyEmployee(ModifyEmployee modifyEmployee) {
        /**
         * -1 => 代表用户ID没有输入或者输入了不存在用户ID
         * -2 => 代表用户名，年龄，邮箱修改为空
         * >0 => 更改信息成功
         */

        AddEmployee employee = employeeMapper.findById(modifyEmployee.getId());
        if (employee == null) {
            throw new IllegalArgumentException("用户ID没有输入或者输入了不存在用户ID");
        }

        if (modifyEmployee.getUsername().trim() == null ||modifyEmployee.getAge() == null ||
            modifyEmployee.getEmail().trim() == null) {
            throw new IllegalArgumentException("用户名，年龄，邮箱修不得改为空");
        }

        Integer result = employeeMapper.modifyEmployee(modifyEmployee.getId(), modifyEmployee.getUsername(),
                modifyEmployee.getAge(),modifyEmployee.getBirthday(),modifyEmployee.getEmail(),modifyEmployee.getAddress());
        return result;
    }

    @Override
    public Integer deleteEmployee(Integer id) {
        Integer result = employeeMapper.deleteEmployee(id);
        return result;
    }

    @Override
    public List<AddEmployee> getAllEmployee() {
        List<AddEmployee> allEmployee = employeeMapper.getAllEmployee();
        return allEmployee;
    }

    @Override
    public AddEmployee getByEmployeeId(Integer id) {
        AddEmployee employee = employeeMapper.findById(id);
        return employee;
    }
}
