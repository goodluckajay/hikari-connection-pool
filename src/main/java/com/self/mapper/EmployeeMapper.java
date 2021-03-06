package com.self.mapper;

import com.self.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int row) throws SQLException
    {
        Employee employee = new Employee();

        employee.setId(rs.getInt(1));
        employee.setName(rs.getString(2));
        employee.setAge(rs.getInt(3));
        employee.setDept(rs.getString(4));

        return employee;
    }
}
