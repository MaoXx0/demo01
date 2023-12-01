package com.demo.controller;

import com.demo.pojo.AddEmployee;
import com.demo.pojo.ModifyEmployee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
    * 专注于添加页面的操作
    * 不做试图展示*/
    @RequestMapping("/add")
    public ModelAndView add(AddEmployee addEmployee) {
        Integer result = employeeService.addEmployee(addEmployee);
        ModelAndView mav = new ModelAndView();
        if (result > 0) {
            mav.setViewName("success");
            mav.addObject("text", "添加成功！！");
        } else {
            System.out.println("添加失败");
            mav.setViewName("Add");
            mav.addObject("warn", "添加失败！！");
        }
        return mav;
    }

    /*
    * 不做任何处理，只做视图展示*/
    @RequestMapping("/addShow")
    public String addShow() {
        return "Add";
    }


    @RequestMapping( "/modifyById/{id}")
    public String modifyById(@PathVariable("id")Integer id,Model model) {
        AddEmployee employees = employeeService.getByEmployeeId(id);
        model.addAttribute("employees",employees);
        return "Modify";
    }

    @RequestMapping("/modifyByMsg")
    public ModelAndView modifyByMsg(ModifyEmployee modifyEmployee) {
        Integer integer = employeeService.modifyEmployee(modifyEmployee);
        ModelAndView mav = new ModelAndView();

        if (integer > 0) {
            mav.setViewName("success");
            mav.addObject("text","成功添加");
        }
        return mav;
    }


    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Integer id) {
        Integer result = employeeService.deleteEmployee(id);
        return "redirect:/list";
    }


    @RequestMapping("/list")
    public String list(Model model) {
        System.out.println("打印的全部员工信息：");
        List<AddEmployee> allEmployee = employeeService.getAllEmployee();
        model.addAttribute("allEmployee",allEmployee);
        return "List";
    }


}
