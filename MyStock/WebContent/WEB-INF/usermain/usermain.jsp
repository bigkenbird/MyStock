<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員管理</title>
<jsp:include page="/WEB-INF/header&footer/header.jsp" flush="true"/>
</head>
<body>
<div id="user_data" name="table_style">
<table id="usertable" name="usertable">
<thead>
<tr>
<th colspan="2">會員資料</th>
</tr>
</thead>
<tbody>
<tr>
<td>帳號</td>
<td>${user.account}</td>
</tr>
<tr>
<td>密碼</td>
<td>${user.password}</td>
</tr>
<tr>
<td>姓名</td>
<td>${user.name}</td>
</tr>
<tr>
<td>財產</td>
<td>${user.money}</td>
</tr>
</tbody>
</table>
</div>
<div id="trans_data" name="table_style">
<table id="transtable" name="transtable">
<thead>
<tr colspan="2">交易資料</tr>
</thead>
<tbody>


</tbody>


</table>
</div>



</body>
</html>