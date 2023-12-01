package com.demo.controller;

import com.demo.pojo.UserRegister;
import com.demo.pojo.UserLogin;
import com.demo.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login_Register_Controller {

    @Autowired
    private LoginRegisterService loginRegisterService;

    @RequestMapping(value = "/login")
    public ModelAndView login(UserLogin userLogin) {
        boolean login = loginRegisterService.login(userLogin);
        ModelAndView mav = new ModelAndView();

        if (login) {
            mav.setViewName("redirect:/list");
        } else {
            mav.setViewName("Login");
            mav.addObject("warnerror","登陆失败");
        }
        return mav;
    }

    /*
    *
    * 专注于逻辑操作
    * 不对页面跳转进行操作
    * */
    @RequestMapping(value = "/register")
    public ModelAndView register(UserRegister userRegister) {
        ModelAndView mav = new ModelAndView();

        if (loginRegisterService.register(userRegister) > 0) {
            mav.setViewName("Login");
        } else {
            System.out.println("warnerror:注册失败");
            mav.setViewName("Register");
            mav.addObject("warnerror","注册失败");
        }
        return mav;
    }

    /*
    *专注于跳转注册页面
    * 不做任何逻辑处理
    * */
    @RequestMapping("/registerShow")
    public String register2() {
        return "Register";
    }


}
