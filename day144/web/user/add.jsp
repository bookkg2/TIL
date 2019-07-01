<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('input[type ="button"]').click(function(){
		var c = confirm('회원가입하시겠습니까?');
		if(c == true){
			$('#r_form').attr('method','post');
			$('#r_form').attr('action','user.do?cmd=useradd');//뒤에 ID,PWD,NAME이 붙어서 req에 보낸다.		
			$('#r_form').submit();
		}
	});
});
</script>
</head>
<body>
<h1>User Add Page</h1>
<form id = "r_form">
ID<input type = "text" name="id"><br>
PWD<input type = "text" name="pwd"><br>
NAME<input type = "text" name="name"><br>
<input type = "button" value="REGISTER"><br>
</form>
</body>
</html>