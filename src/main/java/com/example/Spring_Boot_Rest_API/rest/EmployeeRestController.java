package com.example.Spring_Boot_Rest_API.rest;


import com.example.Spring_Boot_Rest_API.Dao.EmployeeDAO;
import com.example.Spring_Boot_Rest_API.Service.EmployeeService;
import com.example.Spring_Boot_Rest_API.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //private EmployeeDAO employeeDAO;

    private EmployeeService employeeService;


    //quick and dirty: inject employe dao

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    //expose employee and return list employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    @GetMapping("/employess/{employeeId}")
    public Employee getEmployee (@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found " + employeeId);
        }

        return theEmployee;

    }
}
