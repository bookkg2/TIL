<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/event-stream; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int a = (int)(Math.random()*10+1);
	System.out.println("aaaa");
	response.setContentType("text/event-stream;charset=utf-8");
	response.setHeader("Cache-control", "no-cache");
	response.setHeader("Connection", "keep-alive");
	out.write("retry:2000\n");
	out.write("data:"+a+"\n");
	out.flush();
%>






