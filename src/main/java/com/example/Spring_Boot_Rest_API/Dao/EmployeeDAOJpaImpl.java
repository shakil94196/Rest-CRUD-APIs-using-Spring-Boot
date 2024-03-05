package com.example.Spring_Boot_Rest_API.Dao;

import com.example.Spring_Boot_Rest_API.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query

        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);


        //execute query and get result list
        List<Employee>employees=theQuery.getResultList();


        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee theEmployee=entityManager.find(Employee.class,theId);


        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //find employee by id
        Employee theEmployee=entityManager.find(Employee.class,theId);
        entityManager.remove(theId);

    }
}
