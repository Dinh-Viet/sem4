package com.example.Employee.Controller;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Model.EmployeeDAO;
import com.example.Employee.Model.EmployeeDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");

        if (fullName.isEmpty() || birthday.isEmpty() || address.isEmpty() || position.isEmpty() || department.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("employee.jsp").forward(request, response);
        } else {
            Employee employee = new Employee();
            employee.setFullName(fullName);
            employee.setBirthday(birthday);
            employee.setAddress(address);
            employee.setPosition(position);
            employee.setDepartment(department);

            try {
                employeeDAO.addEmployee(employee);
                response.sendRedirect("list");
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }
}