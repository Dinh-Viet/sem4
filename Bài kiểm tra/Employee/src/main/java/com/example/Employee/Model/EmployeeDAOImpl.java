package com.example.Employee.Model;

import com.example.Employee.Entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employee (FullName, Birthday, Address, Position, Department) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = MyConectionDB.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getFullName());
            ps.setDate(2, Date.valueOf(employee.getBirthday()));
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPosition());
            ps.setString(5, employee.getDepartment());
            ps.executeUpdate();
        }
    }


    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (Connection conn = MyConectionDB.getMySQLConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID"));
                employee.setFullName(rs.getString("FullName"));
                employee.setBirthday(rs.getDate("Birthday").toString());
                employee.setAddress(rs.getString("Address"));
                employee.setPosition(rs.getString("Position"));
                employee.setDepartment(rs.getString("Department"));
                employees.add(employee);
            }
        }
        return employees;
    }
}
