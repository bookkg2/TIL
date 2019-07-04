<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="center_page">
<h1>Login Page</h1>
<form action="login.do" method="POST">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<input type="submit" value="LOGIN"><br>
</form>
</div>