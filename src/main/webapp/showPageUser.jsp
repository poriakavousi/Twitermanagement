<%@ page import="com.twitter.entity.User" %>
<%@ page import="com.twitter.entity.Twitt" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Home Page</title>
    <link rel="stylesheet" href="css/timeline.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<% User user=(User) session.getAttribute("userSelected"); %>
<div class="timeline-container">
    <% List<Twitt> twitts = (List<Twitt>) session.getAttribute("twittUserList"); %>
    <% if (twitts != null && !twitts.isEmpty()) { %>
    <% for (Twitt twitt : twitts) { %>
    <div class="tweet">
        <div class="tweet-header">
            <a href="ShowPageUserServlet?userId=<%=twitt.getUser().getId()%>"><%= twitt.getUser().getUsername() %></a>
        </div>
        <div class="tweet-content">
            <%= twitt.getTwittContent() %>
        </div>
        <div class="tweet-footer">
            <a href="FollowUserServlet?id=<%=user.getId()%>">follow</a>
            <a href="IncrementTwittLikeServlet?id=<%=twitt.getId()%>&userId=<%=user.getId()%>"> <i class="fas fa-heart"></i></a>
            <span><%= twitt.getLikeTwitt() %></span>
        </div>
    </div>
    <% } %>
    <% } else { %>
    <div class="tweet">
        <p>هیچ توییتی برای نمایش وجود ندارد.</p>
    </div>
    <% } %>
</div>
</body>
</html>