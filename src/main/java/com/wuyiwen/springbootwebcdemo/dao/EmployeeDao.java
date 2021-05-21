package com.wuyiwen.springbootwebcdemo.dao;

import com.wuyiwen.springbootwebcdemo.pojo.Department;
import com.wuyiwen.springbootwebcdemo.pojo.Employee;
import com.wuyiwen.springbootwebcdemo.pojo.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {


    private static Map<Integer, Employee> employeeMap = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer,Employee>();

        employeeMap.put(1001,new Employee(1001,"AA","323rr2@qq.com",1,new Department(101,"后勤部")));
        employeeMap.put(1002,new Employee(1002,"BB","3sdfs@qq.com",0,new Department(102,"市场部")));
        employeeMap.put(1003,new Employee(1003,"CC","3sdfsf232@qq.com",1,new Department(103,"教研部")));
        employeeMap.put(1004,new Employee(1004,"DD","32bwrgb32@qq.com",0,new Department(104,"运营部")));
        employeeMap.put(1005,new Employee(1005,"EE","323r432@qq.com",1,new Department(105,"小卖部")));
    }

    private static Integer initId = 1006;

    public void addEmployee(EmployeeVO employeeVO){
        Employee employee = new Employee();
        if (employeeVO.getId() == null){
            employee.setId(initId++);
        }
        employee.setId(employeeVO.getId());
        employee.setEmployeeName(employeeVO.getEmployeeName());
        employee.setEmail(employeeVO.getEmail());
        employee.setGender(employeeVO.getGender());
        employee.setDate(employeeVO.getDate());
        employee.setDepartmentName(departmentDao.getDepartmentById(employeeVO.getDepartmentId()));

        employeeMap.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
