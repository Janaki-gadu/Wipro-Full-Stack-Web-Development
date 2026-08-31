<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>Prime Numbers</title>
</head>
<body>

<h1>Prime Numbers</h1>

<table border="1" cellpadding="10">
    <tr>
        <th>Prime Number</th>
    </tr>

<%
    ArrayList<Integer> primes =
        (ArrayList<Integer>) request.getAttribute("primes");

    for (Integer prime : primes) {
%>

    <tr>
        <td><%= prime %></td>
    </tr>

<%
    }
%>

</table>

</body>
</html>