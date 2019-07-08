<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
center_page > img{
 width:80px;
 height:100px;
}

</style>
</head>
<body>
<div class ="center_page">
<h1>product list page</h1>
<c:forEach var="p" items="${plist}">
<h5><img src ="img/${p.imgname}">${p.name} ${p.price}</h5>

</c:forEach>
</div>
</body>
</html>