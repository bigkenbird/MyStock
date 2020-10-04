<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入畫面</title>
</head>
<body>
<div id="userloginform">
<form action="userlogin" method="POST"  name="form_style">
<label for="account">帳號</label>
<input id="account" name="account" type="text">
<label for="password">密碼</label>
<input id="password" name="password" type="text">
<input type="submit" id="send" name="send" value="提交">
</form>
</div>
<div id="sendtousersignup">
<form action="usersignup" method="GET"  name="form_style">
<input type="submit" id="sendbutton" name="sendbutton" value="會員註冊">
</form>
</div>

</body>
</html>