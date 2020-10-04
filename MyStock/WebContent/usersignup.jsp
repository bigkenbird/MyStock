<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
</head>
<body>
<div id="usersignupform" name="form_style">
<form action="usersignup" method="post">
<label for="account">帳號註冊</label>
<input id="account" name="account" type="text">
<label for="password">密碼註冊</label>
<input type="password" id="password" name="password">
<label for="name">姓名</label>
<input id="name" name="name">
<label for="money">財產</label>
<input type="number" id="money" name="money">
<input type="submit" id="send" name="send" value="提交">
 </form>
</div>

<div id="status_style" name="status_style">
<span value="${status}"></span>

</div>
</body>
</html>