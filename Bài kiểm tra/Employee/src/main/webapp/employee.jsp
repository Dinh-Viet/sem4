<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2024
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<!-- WebContent/employee.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<form method="post" action="addEmployee">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName"><br>

    <label for="birthday">Birthday:</label>
    <input type="date" id="birthday" name="birthday"><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address"><br>

    <label for="position">Position:</label>
    <input type="text" id="position" name="position"><br>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department"><br>

    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
<p style="color:red;"><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %></p>
</body>
</html>

