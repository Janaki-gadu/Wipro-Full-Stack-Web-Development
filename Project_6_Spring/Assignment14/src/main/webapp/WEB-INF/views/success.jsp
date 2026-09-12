<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cash Back Success</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; }
        .box { width: 470px; margin: 80px auto; padding: 25px; background: #ff7f73; }
    </style>
</head>
<body>
<div class="box">
    <h1>Congratulations</h1>
    <h2>You received a ${percentage}% cash back offer</h2>
    <h3>Your cash back amount is: ${cashback}</h3>
    <h3>Your updated new balance is: ${updatedBalance}</h3>
    <a href="${pageContext.request.contextPath}/offer">Back to Offer</a>
</div>
</body>
</html>
