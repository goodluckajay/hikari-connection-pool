package com.self.impl;

import com.self.dao.EmployeeDAO;
import com.self.entity.Employee;
import com.self.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees()
    {
        String sql = "select id, name, age, dept from Hikari";
        List<Employee> employeeList = jdbcTemplate.query(sql, new EmployeeMapper());
        System.out.println("size : " + employeeList.size());
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        String sql = "select id, name, age, dept from Hikari where id = ?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
        return employee;
    }

    @Override
    public void addEmployee(Employee employee)
    {
        String sql = "insert into Hikari (id, name, age, dept) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getAge(), employee.getDept());
    }

    @Override
    public void updateEmployee(Employee employee)
    {
        String sql = "update Hikari set name = ?, age = ?, dept = ? where id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getDept(), employee.getId());
    }

    @Override
    public void deleteEmployee(int id)
    {
        String sql = "delete from Hikari where id = ?";
        jdbcTemplate.update(sql, id);
    }
}