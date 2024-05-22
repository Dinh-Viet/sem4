package com.example.Employee.Model;

import com.example.Employee.Entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
}
