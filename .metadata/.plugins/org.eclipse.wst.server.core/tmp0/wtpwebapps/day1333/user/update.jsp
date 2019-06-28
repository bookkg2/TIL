<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1>User Update Page</h1>
<form action="req?type=user&cmd=updateimpl" method="POST">
ID<input readonly value="${uu.id }" type="text" name="id"><br>
PWD<input value="${uu.pwd }" type="text" name="pwd"><br>
NAME<input value="${uu.name }" type="text" name="name"><br>
<input type="submit" value="UPDATE"><br>
</form>
</body>
</html>




