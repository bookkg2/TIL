<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<style>
.center_page>img{
	width:80px;
	height:100px;
}

</style>


<div class ="center_page">
<h1>Product List Page</h1>
<c:forEach var="p" items ="${plist }">
<h4><img src="img/${p.imgname }">${p.name} ${p.price}</h4>
</c:forEach>
</div>