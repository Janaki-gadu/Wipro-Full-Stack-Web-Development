<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head><title>Login</title></head><body>
<h1>Login</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <button type="submit">LOGIN</button>
</form>
</body></html>
