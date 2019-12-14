package com.zuoshao.springboot.controller;

import com.zuoshao.springboot.dao.DepartmentDao;
import com.zuoshao.springboot.dao.EmployeeDao;
import com.zuoshao.springboot.entities.Department;
import com.zuoshao.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zuoshao
 * @date 2019/3/18 - 13:56
 */
@Controller
public class EmployeeController {
    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回员工列表
    @GetMapping("/emps")
    //把查到的东西放入请求域当中。其中model map modelmap 都可以放
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "list.html";
    }

    @GetMapping("/emp")
    public String addview(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "add.html";
    }

    @PostMapping("/emp")
    //关于SpringMVC自动映射属性的添加操作
    //它要求外部需要添加的属性名就是（name） 要与映射类对象的字段名一致就能实现自动装配
    public String addemployee(Employee employee) {

        System.out.println(employee);
        employeeDao.save(employee);
        //redirect 重定向到一个地址 /代表当前路径
        //forward 转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp{id}")
    public String updateemp(@PathVariable("id") Integer id, Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        Employee employee = employeeDao.get(id);
        System.out.println(employee);
        model.addAttribute("emp", employee);
        //点了过后回到修改页面
        return "add.html";
    }

    @PutMapping("/emp")
    public String empupdate(Employee employee) {
        System.out.println("employee" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/empd{id}")
    public String deleteemp(@PathVariable("id") int id) {

        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
