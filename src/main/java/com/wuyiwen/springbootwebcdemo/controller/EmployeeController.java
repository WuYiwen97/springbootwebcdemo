package com.wuyiwen.springbootwebcdemo.controller;


import com.wuyiwen.springbootwebcdemo.dao.DepartmentDao;
import com.wuyiwen.springbootwebcdemo.dao.EmployeeDao;
import com.wuyiwen.springbootwebcdemo.pojo.Department;
import com.wuyiwen.springbootwebcdemo.pojo.Employee;
import com.wuyiwen.springbootwebcdemo.pojo.vo.EmployeeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DepartmentDao departmentDao;


    @RequestMapping("/emp")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //to员工添加页面
    @GetMapping("/add")
    public String toAdd(Model model){
        //查出所有的部门，提供选择
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //员工添加功能，使用post接收
    @PostMapping("/add")
    public String add(EmployeeVO employeeVO){
        //保存员工信息
        employeeDao.addEmployee(employeeVO);
        //回到员工列表页面，可以使用redirect或者forward
        return "redirect:/emp";
    }

    //to员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //根据id查出来员工
        Employee employee = employeeDao.getEmployeeById(id);
        //将员工信息返回页面
        model.addAttribute("emp",employee);
        //查出所有的部门，提供修改选择
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(EmployeeVO employeeVO){
        employeeDao.addEmployee(employeeVO);
        //回到员工列表页面
        return "redirect:/emp";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        //根据id删除员工
        employeeDao.delete(id);
        return "redirect:/emp";
    }





}
