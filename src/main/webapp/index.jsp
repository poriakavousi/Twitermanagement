<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to Twitter</title>
    <link rel="stylesheet" href="css/logincss.css">
</head>
<body>
<form action="LoginUserServlet" class="box" method="post" autocomplete="off">
  <img src="image/twitter.png" alt="Twitter Logo" class="logo">
  <h1>Login</h1>
    <input type="text" placeholder="username" name="username" required><br><br>
    <input type="password" placeholder="password" name="password" required><br><br>
    <input type="submit" name="submit" value="login"><br><br>
    <a href="register.jsp">Do you hav'nt account?</a>
</form>
</body>
</html>
