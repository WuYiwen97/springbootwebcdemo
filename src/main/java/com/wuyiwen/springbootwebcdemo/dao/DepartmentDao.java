package com.wuyiwen.springbootwebcdemo.dao;

import com.wuyiwen.springbootwebcdemo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();

        departmentMap.put(101,new Department(101,"教学部"));
        departmentMap.put(102,new Department(102,"市场部"));
        departmentMap.put(103,new Department(103,"教研部"));
        departmentMap.put(104,new Department(104,"运营部"));
        departmentMap.put(105,new Department(105,"小卖部"));
    }


    public Collection<Department> getDepartment(){
        return departmentMap.values();
    }

    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }

}
