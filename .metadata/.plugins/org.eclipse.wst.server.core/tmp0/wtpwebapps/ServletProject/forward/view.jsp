<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String viewPageURI = null;
	
	if(code.equals("A")){
		viewPageURI = "veiwModule/a.jsp";
	}else if(code.equals("B")){
		viewPageURI = "veiwModule/b.jsp";
	}else if(code.equals("C")){
		viewPageURI = "veiwModule/c.jsp";
	}
%>

<jsp:forward page="<%=viewPageURI %>" />