package com.wuyiwen.springbootwebcdemo.pojo.vo;

import com.wuyiwen.springbootwebcdemo.pojo.Department;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeVO {

    private Integer id;
    private String employeeName;
    private String email;
    private Integer gender;  //0 -female
    private Integer departmentId;
    private Date date;
}
