
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ایجاد توییت جدید</title>
    <link rel="stylesheet" href="css/newTwitt.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<div class="tweet-box">
    <div class="tweet-box-input">
        <div class="profile-circles">
            <div class="circle red"></div>
            <div class="circle green"></div>
            <div class="circle blue"></div>
        </div>
        <form action="registerTwittSevrlet" method="post" autocomplete="off">
            <textarea name="contentTwitt" placeholder=": برای توییت جدید متن خود را وارد کنید  "></textarea>
            <button type="submit">Tweet</button>
        </form>
    </div>
</div>
</body>
</html>
