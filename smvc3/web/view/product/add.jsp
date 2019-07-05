<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>product add page</h1>

<form enctype="multipart/form-data" action="productaddimpl.mc" method="POST">
NAME<input type="text" name="name"><br>
PRICE<input type="number" name="price"><br>
IMG<input type="file" name="mf"><br>
<input type="submit" value="REGISTER"><br>
</form>
</body>
</html>