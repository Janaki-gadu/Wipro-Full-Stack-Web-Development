<jsp:useBean id="employee"
             class="beans.EmployeeBean"
             scope="request" />

<jsp:setProperty name="employee" property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>

<h1>Employee Information</h1>

<p>
    Employee Name:
    <%= employee.getName() %>
</p>

<p>
    Employee ID:
    <%= employee.getId() %>
</p>

</body>
</html>