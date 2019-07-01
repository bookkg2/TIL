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
	$('input[value="delete"]').click(function(){
		var c = confirm('삭제 하시겠습니까?');
		
		if(c == true){
			location.href='user.do?cmd=delete&id=${ud.id}';
		}
		
	});
	
   /*  $('button:eq(1)').click(function(){
		var c = confirm('수정 하시겠습니까?');
		if(c == true){
			location.href='req?type=user&cmd=update&id=${ud.id}';
		}
	}); */
});
</script>
</head>
<body>
<h1>User Detail Page</h1>
<input type="button" value="delete"></button>
<button>UPDATE</button>
<h4>${ud.id } </h4>
<h4>${ud.pwd } </h4>
<h4>${ud.name } </h4>


</body>
</html>