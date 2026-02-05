
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new User</title>
    <link rel="stylesheet" href="css/registercss.css">
</head>
<body>
<form action="RegisterUserServlet" class="box" method="post" autocomplete="off">
    <img src="image/twitter.png" alt="Twitter Logo" class="logo">
    <h1>Register new User</h1>
    <input type="text" placeholder="username" name="username" required><br><br>
    <input type="password" placeholder="password" name="password" required><br><br>
    <input type="password" placeholder="repeatpassword" name="repeatpassword" required><br><br>
    <input type="submit" name="submit" value="register"><br><br>
</form>
</body>
</html>
