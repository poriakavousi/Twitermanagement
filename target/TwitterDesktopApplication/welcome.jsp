<%@ page import="com.twitter.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome to twitter</title>
    <link rel="stylesheet" href="css/welcome.css">
</head>
<body>
<% User user=(User) session.getAttribute("user"); %>
<h2 dir="rtl"> خوش آمدید <%=user.getUsername()%></h2>
<div class="container">

 <a href="newTwitt.jsp"><button>توییت جدید</button></a>
 <a href="ShowFollowerServlet?userId=<%=user.getId()%>"><button> مشاهده دنبال کنندگان</button></a>
 <a href="ShowTimelineServlet"><button>مشاهده ی اکسپلورر</button></a>
 <a href="searchTwitt.jsp"><button>جستجوی توییت</button></a>
 <a href="searchUser.jsp"><button>جستجوی کاربران</button></a>

</div>
</body>
</html>
