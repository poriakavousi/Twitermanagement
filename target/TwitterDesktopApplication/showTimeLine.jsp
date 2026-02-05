<%@ page import="java.util.List" %>
<%@ page import="com.twitter.entity.Twitt" %>
<%@ page import="com.twitter.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>تایم‌لاین</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style> a { text-decoration: none; } </style>
</head>
<body style="font-family: Arial, sans-serif; direction: rtl; margin: 0; padding: 20px; min-height: 100vh; background: linear-gradient(to right top, #1e3c72, #2a5298); background-attachment: fixed; color: #f0f0f0;">

<% User currentUser = (User) session.getAttribute("user"); %>

<div style="display: flex; justify-content: center; gap: 20px; align-items: flex-start;">

    <%-- Profile & Followers Sidebar --%>
    <% if (currentUser != null) { %>
    <aside style="width: 280px; padding: 20px; background: rgba(255, 255, 255, 0.1); border-radius: 16px; box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1); backdrop-filter: blur(5px); -webkit-backdrop-filter: blur(5px); border: 1px solid rgba(255, 255, 255, 0.3); text-align: center;">
        <img src="https://via.placeholder.com/80" alt="Profile Picture" style="width: 80px; height: 80px; border-radius: 50%; margin: 0 auto 15px auto; object-fit: cover;">

        <div style="font-weight: bold; font-size: 1.4em; margin-bottom: 20px;"><%= currentUser.getUsername() %></div>
        <div style="display: flex; justify-content: space-around; text-align: center;">
            <a href="ShowFollowerListServlet" style="color: #f0f0f0;">
                <span>فالوورها</span>
                <span style="font-weight: bold; font-size: 1.2em; display: block;">0</span>
            </a>
            <a href="#" style="color: #f0f0f0;">
                <span>فالووینگ</span>
                <span style="font-weight: bold; font-size: 1.2em; display: block;"><%= currentUser.getFollowing() != null ? currentUser.getFollowing().size() : 0 %></span>
            </a>
        </div>
    </aside>
    <% } %>

    <%-- Main Timeline Container --%>
    <main style="width: 100%; max-width: 600px;">
        <% List<Twitt> twitts = (List<Twitt>) session.getAttribute("twittList"); %>
        <% if (twitts != null && !twitts.isEmpty()) { %>
            <% for (Twitt twitt : twitts) { %>
                <div style="background: rgba(255, 255, 255, 0.1); border-radius: 16px; box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1); backdrop-filter: blur(5px); -webkit-backdrop-filter: blur(5px); border: 1px solid rgba(255, 255, 255, 0.3); margin-bottom: 20px; padding: 20px;">
                    <div style="display: flex; align-items: center; gap: 10px; margin-bottom: 15px;">
                        <img src="https://via.placeholder.com/48" alt="User Profile" style="width: 48px; height: 48px; border-radius: 50%; object-fit: cover;">
                        <a href="ShowPageUserServlet?userId=<%= twitt.getUser().getId() %>" style="font-weight: bold; color: #fff;"><%= twitt.getUser().getUsername() %></a>
                    </div>
                    <div style="line-height: 1.6; margin-bottom: 15px; white-space: pre-wrap;"><%= twitt.getTwittContent() %></div>
                    <div style="display: flex; align-items: center; gap: 20px; color: #ccc;">
                        <a href="FollowUserServlet?id=<%= twitt.getUser().getId() %>" style="color: #ccc;"><i class="fas fa-user-plus"></i> فالو</a>
                        <a href="MentionServlet?id=<%= twitt.getId() %>" style="color: #ccc;"><i class="fas fa-comment"></i> نظر</a>
                        <a href="IncrementTwittLikeServlet?id=<%= twitt.getId() %>" style="color: #ccc;">
                            <i class="fas fa-heart"></i>
                            <span><%= twitt.getLikeTwitt() != null ? twitt.getLikeTwitt() : 0 %></span>
                        </a>
                    </div>
                </div>
            <% } %>
        <% } else { %>
            <div style="background: rgba(255, 255, 255, 0.1); border-radius: 16px; box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1); backdrop-filter: blur(5px); -webkit-backdrop-filter: blur(5px); border: 1px solid rgba(255, 255, 255, 0.3); padding: 20px;">
                <p>هیچ توییتی برای نمایش وجود ندارد.</p>
            </div>
        <% } %>
    </main>

</div>
</body>
</html>
