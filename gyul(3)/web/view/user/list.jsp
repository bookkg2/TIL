<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class ="center_page">
<h1>User List Page</h1>
<c:forEach var="u" items ="${ulist }">
<h4><a href="userdetail.mc?id=${u.id}">${u.id}</a> ${u.name}</h4>
</c:forEach>
</div>