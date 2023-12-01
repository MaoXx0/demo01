package com.demo.service.Impl;

import com.demo.pojo.UserRegister;
import com.demo.mapper.LoginRegisterMapper;
import com.demo.pojo.UserLogin;
import com.demo.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Autowired
    private LoginRegisterMapper loginRegisterMapper;
    @Override
    public boolean login(UserLogin userLogin) {
        UserLogin user = loginRegisterMapper.findByUsername(userLogin.getUsername());

        if (user == null) {
            return false;
        } else {
            if (!user.getPassword().equals(userLogin.getPassword())) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public Integer register(UserRegister userRegister) {

        if (userRegister.getUsername().trim() == null || userRegister.getPasswordFirst().trim() == null || userRegister.getPasswordSecond().trim() == null) {
            throw new IllegalArgumentException("用户名、密码和确认密码不能为空！");
        }

        UserLogin user = loginRegisterMapper.findByUsername(userRegister.getUsername());
        if (user != null) {
            throw new IllegalArgumentException("用户名已存在，请选择其他用户名！");
        }

        if (!userRegister.getPasswordFirst().equals(userRegister.getPasswordSecond())) {
            throw new IllegalArgumentException("两次输入的密码不匹配，请重新输入！");
        }

        return loginRegisterMapper.registerToTable(userRegister.getUsername(), userRegister.getPasswordFirst());


    }
}
