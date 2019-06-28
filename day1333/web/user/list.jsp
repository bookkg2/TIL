<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<h1>User List Page</h1>
<c:forEach var="u" items="${ulist}">
<h5><a href="req?type=user&cmd=detail&id=${u.id }">${u.id }</a>  ${u.name }</h5>
</c:forEach>
</body>
</html>











