<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="center_page">
<h1>Main Center Page</h1>
<spring:message code="welcome.txt"
arguments ="hi,mulcam"></spring:message>
</div>