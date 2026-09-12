<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cash Back Offer</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; }
        .box { width: 500px; margin: 60px auto; padding: 25px; background: #ff7f73; }
        input { padding: 7px; width: 210px; }
        button { padding: 7px 16px; }
        .error { background: #ffe0e0; padding: 10px; margin-bottom: 12px; }
        .logout { float: right; }
    </style>
</head>
<body>
<div class="box">
    <a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a>
    <h1>Your Current Balance is: ${customer.balance}</h1>
    <h2>Claim your Cash Back here</h2>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error">${error}</div>
    <% } %>

    <form method="post" action="${pageContext.request.contextPath}/claim">
        <label>Enter Coupon Code:</label>
        <input type="text" name="couponCode" required maxlength="20">
        <button type="submit">CLAIM</button>
    </form>
</div>
</body>
</html>
