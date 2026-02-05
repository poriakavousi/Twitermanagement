<%@ page import="com.twitter.entity.Twitt" %>
<%@ page import="com.twitter.entity.User" %>
<%@ page import="com.twitter.util.ApplicationContext" %>
<%@ page import="com.twitter.entity.Mention" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Twitt twitt = (Twitt) session.getAttribute("twitt");
    List<Mention> mentionThisTwitt = new ArrayList<>();

    if (twitt != null) {
        try {
            List<Mention> allMentions = ApplicationContext.getMentionService().findAll();
            for (Mention mention : allMentions) {
                if (mention != null && mention.getTwitt() != null && mention.getTwitt().getId().equals(twitt.getId())) {
                    mentionThisTwitt.add(mention);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>

<html>
<head>
    <title>اظهار نظر برای توییت</title>
</head>
<body style="font-family: Arial, sans-serif; direction: rtl; margin: 0; padding: 20px; min-height: 100vh; background: linear-gradient(to right top, #1e3c72, #2a5298); background-attachment: fixed;">

<div style="max-width: 700px; margin: 20px auto; padding: 20px; background: rgba(255, 255, 255, 0.1); border-radius: 16px; box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1); backdrop-filter: blur(5px); -webkit-backdrop-filter: blur(5px); border: 1px solid rgba(255, 255, 255, 0.3);">

    <% if (twitt == null) { %>
        <div style="text-align: center; color: #fff;">
            <h1 style="color: #ff6b6b;">خطا!</h1>
            <p style="font-size: 1.1em;">توییت مورد نظر برای نمایش پیدا نشد. لطفاً به صفحه اصلی بازگردید و دوباره تلاش کنید.</p>
        </div>
    <% } else { %>
        <div style="border-bottom: 1px solid rgba(255, 255, 255, 0.2); padding-bottom: 15px; margin-bottom: 20px; font-size: 1.2em; line-height: 1.5; color: #fff;">
            <p><%= twitt.getTwittContent() %></p>
        </div>

        <div>
            <h3 style="color: #fff; text-shadow: 0 1px 2px rgba(0,0,0,0.2); margin-bottom: 15px;">نظر خود را بنویسید:</h3>
            <form name="send-mention" method="post" action="RegisterMentionServlet" style="display: flex; flex-direction: column; gap: 10px;">
                <textarea name="mentionText" placeholder="چه نظری دارید؟" style="width: 100%; padding: 10px; border: 1px solid rgba(255, 255, 255, 0.5); border-radius: 8px; font-size: 1em; min-height: 80px; box-sizing: border-box; background: rgba(255, 255, 255, 0.2); color: #fff;"></textarea>
                <input type="hidden" value="<%= twitt.getId() %>" name="id">
                <input type="submit" value="ثبت نظر" style="background-color: #1da1f2; color: white; padding: 10px 15px; border: none; border-radius: 20px; cursor: pointer; font-size: 1em; font-weight: bold; align-self: flex-start;">
            </form>
        </div>

        <div style="margin-top: 30px;">
            <h3 style="color: #f0f0f0; border-bottom: 1px solid rgba(255, 255, 255, 0.2); padding-bottom: 10px;">نظرات</h3>
            <% if (mentionThisTwitt.isEmpty()) { %>
                <p style="color: #f0f0f0;">هنوز نظری برای این توییت ثبت نشده است.</p>
            <% } else {
                for (Mention mention : mentionThisTwitt) { %>
                    <div style="padding: 15px 0; border-bottom: 1px solid rgba(255, 255, 255, 0.2);">
                        <p style="margin: 0; color: #f0f0f0;"><%= mention.getMentionContent() %></p>
                    </div>
                <% }
            } %>
        </div>
    <% } %>

</div>

</body>
</html>
