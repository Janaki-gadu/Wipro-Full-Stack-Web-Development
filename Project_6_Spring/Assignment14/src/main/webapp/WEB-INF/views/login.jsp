<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Legion Bank - Login</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; }
        .box { width: 430px; margin: 80px auto; padding: 25px; background: #ff7f73; }
        h1 { margin-top: 0; }
        label { display: inline-block; width: 105px; margin: 8px 0; }
        input { padding: 7px; width: 210px; }
        button { padding: 7px 16px; margin-top: 8px; }
        .error { background: #ffe0e0; padding: 10px; margin-bottom: 12px; }
    </style>
</head>
<body>
<div class="box">
    <h1>Enter your Login Details</h1>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error">${error}</div>
    <% } %>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <label>Customer ID:</label>
        <input type="text" name="customerId" required maxlength="20"><br>

        <label>Password:</label>
        <input type="password" name="password" required maxlength="50"><br>

        <button type="submit">LOGIN</button>
    </form>
</div>
</body>
</html>
