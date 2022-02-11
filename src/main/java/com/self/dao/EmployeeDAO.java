package com.self.dao;

import com.self.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
