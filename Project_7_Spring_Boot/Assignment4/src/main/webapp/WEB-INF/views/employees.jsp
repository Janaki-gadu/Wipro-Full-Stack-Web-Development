<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head><title>Employee Management System</title></head><body>
<h1>Employee Management System</h1>
<form method="post" action="${pageContext.request.contextPath}/save">
    <input type="hidden" name="id" value="${employee.id}">
    Name: <input name="name" value="${employee.name}" required><br>
    Designation: <input name="designation" value="${employee.designation}" required><br>
    Salary: <input name="salary" type="number" step="0.01" value="${employee.salary}" required><br>
    <button type="submit">SAVE</button>
</form>
<h2>Employees</h2>
<table border="1" cellpadding="6">
    <tr><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th><th>Actions</th></tr>
    <c:forEach var="e" items="${employees}">
        <tr>
            <td>${e.id}</td><td>${e.name}</td><td>${e.designation}</td><td>${e.salary}</td>
            <td>
                <a href="${pageContext.request.contextPath}/edit/${e.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/delete/${e.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body></html>
