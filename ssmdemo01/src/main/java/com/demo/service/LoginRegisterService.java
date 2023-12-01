package com.demo.service;

import com.demo.pojo.UserRegister;
import com.demo.pojo.UserLogin;

public interface LoginRegisterService {
    boolean login(UserLogin userLogin);
    Integer register(UserRegister registerForm);
}
