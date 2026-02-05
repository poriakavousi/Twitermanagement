
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Login</title>
    <link rel="stylesheet" href="css/logincss.css">
</head>
<body>
<p style="color: red;margin: 0 auto">Entry data  is wrong</p>
<form action="LoginUserServlet" class="box" method="post" autocomplete="off">
    <h1>Login</h1>
    <input type="text" placeholder="username" name="username" required><br><br>
    <input type="password" placeholder="password" name="password" required><br><br>
    <input type="submit" name="submit" value="login"><br><br>
    <a href="register.jsp">Do you hav'nt account?</a>
</form>
</body>
</html>
