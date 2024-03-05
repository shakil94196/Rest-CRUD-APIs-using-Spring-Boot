package com.example.Spring_Boot_Rest_API.Dao;

import com.example.Spring_Boot_Rest_API.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee  theEmployee);

    void deleteById(int theId);






}




