<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>user list page</h1>
<c:forEach var="u" items="${userlist }">
	<h4><a href="userdetail.mc?id=${u.id}">${u.id} ${u.name}</a></h4>

</c:forEach>
</body>
</html>