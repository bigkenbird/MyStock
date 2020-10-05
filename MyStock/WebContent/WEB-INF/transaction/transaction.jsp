<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>交易</title>
<jsp:include page="/WEB-INF/header&footer/header.jsp" flush="true"/>
</head>
<body>
<form action="transactioninputservlet" method="post">
<label for="account">買賣帳號</label>
<input id="account" name="account" type="text">
<label for="stocksymbol">股票代號</label>
<input type="text" id="stocksymbol" name="stocksymbol">
<label for="component">公司名稱</label>
<input type="text" id="component" name="component">
<label for="trans_type">買或賣</label>
<input type="text" id="trans_type" name="trans_type">
<label for="shares_num">交易股份</label>
<input type="number" id="shares_num" name="shares_num">
<input type="submit" id="send" name="send" value="提交">




</form>
</body>
</html>