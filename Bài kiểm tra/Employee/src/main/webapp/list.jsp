<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2024
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<!-- WebContent/list.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Employee.Entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h2>Employee List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Position</th>
        <th>Department</th>
    </tr>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        for (Employee employee : employees) {
    %>
    <tr>
        <td><%= employee.getId() %></td>
        <td><%= employee.getFullName() %></td>
        <td><%= employee.getBirthday() %></td>
        <td><%= employee.getAddress() %></td>
        <td><%= employee.getPosition() %></td>
        <td><%= employee.getDepartment() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
