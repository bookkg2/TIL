<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

header, nav, section, footer {
	margin: 0 auto;
}

a {
	text-decoration: none;
	color: black;
}

header {
	width: 900px;
	height: 150px;
	background: red;
}

nav {
	width: 900px;
	height: 30px;
	background: pink;
}

section {
	width: 900px;
	height: 600px;
	background: gray;
	
}

footer {
	width: 900px;
	height: 50px;
	background: black;
}

.center_page{
	margin :0 auto;
	width:880px;
	height: 580px;
	background: white;
}
</style>
</head>
<body>
	<header>
	<h3>
	<c:choose>
		<c:when test= "${loginuser != null}">
		<a href="">${loginuser.id }</a>
		<a href="logout.mc">LOGOUT</a> <!-- default : get -->
		<a href="main.do?view=about_us">ABOUT US</a>
		</c:when>
		
		<c:otherwise>
			<a href="login.mc">LOGIN</a> <a href="register.mc">REGISTER</a> <a href="about_us.mc">ABOUT US</a>
		</c:otherwise>
	</c:choose>
		
		</h3>
		<h1><a href="useradd.mc">USERADD</a> 
		<a href="userlist.mc">USERLIST</a> 
		<a href="productadd.mc">PRODUCTADD</a> 
		<a href="productlist.mc">PRODUCTLIST</a></h1>
	</header>
	<nav>
	<c:choose>
		<c:when test= "${navi == null }">
			<a href="main.mc">HOME</a>
		</c:when>
		<c:otherwise>
			${navi }
		</c:otherwise>
	</c:choose>
	
	</nav>
	<section>
	<c:choose>
		<c:when test="${center == null }">
			<jsp:include page = "center.jsp"></jsp:include>
		</c:when>
			
		<c:otherwise>
			<jsp:include page = "${center }.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	</section>
	<footer></footer>
</body>
</html>