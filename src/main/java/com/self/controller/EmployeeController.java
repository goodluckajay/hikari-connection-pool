package com.self.controller;

import com.self.entity.Employee;
import com.self.impl.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeDAOImpl employeeDAOImpl;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        System.out.println("test app");

        List employeeList = employeeDAOImpl.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
    {
        Employee employee = employeeDAOImpl.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        System.out.println("postman id :" + employee.getId()) ;
        employeeDAOImpl.addEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        employeeDAOImpl.updateEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeDAOImpl.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
