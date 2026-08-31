<!DOCTYPE html>
<html>
<head>
    <title>Factorial Table</title>
</head>
<body>

<h1>Factorial Table</h1>

<table border="1" cellpadding="10">
    <tr>
        <th>Number</th>
        <th>Factorial</th>
    </tr>

<%
    for (int i = 1; i <= 10; i++) {

        long factorial = 1;

        for (int j = 1; j <= i; j++) {
            factorial = factorial * j;
        }
%>

    <tr>
        <td><%= i %></td>
        <td><%= factorial %></td>
    </tr>

<%
    }
%>

</table>

</body>
</html>