<%@ page import="beans.EmployeeBean" %>

<jsp:useBean id="employee"
             class="beans.EmployeeBean"
             scope="request" />

<jsp:setProperty name="employee" property="*" />

<%
    Class.forName("com.mysql.cj.jdbc.Driver");

    java.sql.Connection connection =
        java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/wipro_training",
            "root",
            "root"
        );

    java.sql.PreparedStatement statement =
        connection.prepareStatement(
            "INSERT INTO emp (name, id, designation) VALUES (?, ?, ?)"
        );

    statement.setString(1, employee.getName());
    statement.setInt(2, employee.getId());
    statement.setString(3, employee.getDesignation());

    statement.executeUpdate();

    statement.close();
    connection.close();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Added</title>
</head>
<body>

<h1>Employee Added Successfully</h1>

<table border="1" cellpadding="10">
    <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Designation</th>
    </tr>

    <tr>
        <td><%= employee.getName() %></td>
        <td><%= employee.getId() %></td>
        <td><%= employee.getDesignation() %></td>
    </tr>
</table>

</body>
</html>