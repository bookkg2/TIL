<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>User Detail page</h1>

<h1>${userdetail.id}</h1>
<h1>${userdetail.pwd}</h1>
<h1>${userdetail.name}</h1>
<a href="userdelete.mc?id=${userdetail.id}">Delete</a>
<a href="userupdate.mc?id=${userdetail.id}">Update</a>
</body>
</html>