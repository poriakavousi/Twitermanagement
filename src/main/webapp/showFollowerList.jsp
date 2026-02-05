<%@ page import="com.twitter.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>لیست فالوورها</title>
</head>
<body style="font-family: Arial, sans-serif; direction: rtl; margin: 0; padding: 20px; min-height: 100vh; background: linear-gradient(to right top, #1e3c72, #2a5298); background-attachment: fixed;">

<h1 style="text-align: center; color: #fff; text-shadow: 0 2px 4px rgba(0,0,0,0.2);">لیست فالوورها</h1>

<div style="max-width: 600px; margin: 20px auto; padding: 20px; background: rgba(255, 255, 255, 0.1); border-radius: 16px; box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1); backdrop-filter: blur(5px); -webkit-backdrop-filter: blur(5px); border: 1px solid rgba(255, 255, 255, 0.3);">
    <%
        List<User> followerList = (List<User>) session.getAttribute("followerList");
        if (followerList != null && !followerList.isEmpty()) {
            for (int i = 0; i < followerList.size(); i++) {
                User user = followerList.get(i);
                String borderStyle = (i == followerList.size() - 1) ? "" : "border-bottom: 1px solid rgba(255, 255, 255, 0.2);";
    %>
    <div style="display: flex; align-items: center; justify-content: space-between; padding: 15px; <%= borderStyle %>">

        <div style="display: flex; align-items: center; gap: 15px;">
            <img src="https://via.placeholder.com/48" alt="Profile Picture" style="width: 48px; height: 48px; border-radius: 50%; object-fit: cover;">
            <p style="font-weight: bold; font-size: 1.1em; color: #f0f0f0; margin: 0;"><%= user.getUsername() %></p>
        </div>

        <button style="background-color: #1da1f2; color: white; padding: 8px 16px; border: none; border-radius: 20px; cursor: pointer; font-weight: bold; white-space: nowrap;">
            فالو کردن
        </button>

    </div>
    <%
            }
        } else {
    %>
    <p style="text-align: center; color: #f0f0f0;">شما هنوز هیچ فالووری ندارید.</p>
    <%
        }
    %>
</div>

</body>
</html>
