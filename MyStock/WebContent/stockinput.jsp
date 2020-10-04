<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>股票創建</title>
</head>
<body>
<div id="form_style" name="form_style">
<form action="stockinput" method="post">
<label for="stocksymbol">股票代號</label>
<input type="text" id="stocksymbol" name="stocksymbol">
<label for="component">公司名稱</label>
<input type="text" id="component" name="component">
<label for="price">股價</label>
<input type="number" id="price" name="price">
<input type="submit" id="send" name="send" value="提交">
</form>
</div>

<div id="status_style" name="status_style">
<label for="status">${status}</label>
</div>
</body>
</html>