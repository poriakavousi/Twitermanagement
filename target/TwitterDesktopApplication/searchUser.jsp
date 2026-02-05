<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>جستجوی کاربر</title>
</head>
<body style="font-family: Arial, sans-serif; direction: rtl; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; min-height: 100vh; background: linear-gradient(to right top, #1e3c72, #2a5298); background-attachment: fixed;">

<div style="width: 100%; max-width: 450px; padding: 40px; text-align: center; background: rgba(255, 255, 255, 0.1); border-radius: 16px; box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1); backdrop-filter: blur(5px); -webkit-backdrop-filter: blur(5px); border: 1px solid rgba(255, 255, 255, 0.3);">

    <h1 style="color: #fff; margin-bottom: 30px; text-shadow: 0 2px 4px rgba(0,0,0,0.2);">جستجوی کاربر</h1>

    <div style="display: flex; flex-direction: column; gap: 20px;">
        <form action="SearchUserServlet" method="get" style="display: flex; flex-direction: column; gap: 20px;">
            <label for="user-search" style="font-weight: bold; color: #f0f0f0; font-size: 1.1em;">نام کاربری را وارد کنید:</label>
            <input type="text" id="user-search" name="user-search" placeholder="مثال: a_mohammadi" style="padding: 12px; border: 1px solid rgba(255, 255, 255, 0.5); border-radius: 8px; font-size: 1em; width: 100%; box-sizing: border-box; background: rgba(255, 255, 255, 0.2); color: #fff;">
            <input type="submit" value="جستجو" style="background-color: #1da1f2; color: white; padding: 12px; border: none; border-radius: 8px; cursor: pointer; font-size: 1.1em; font-weight: bold;">
        </form>
    </div>
</div>

</body>
</html>
