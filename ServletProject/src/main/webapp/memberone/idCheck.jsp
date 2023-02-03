<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="dao" class="com.memberone.StudentDAO" />

<%
	String id = request.getParameter("id");
	boolean check = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#ffffcc">
<br>
<div align="center">
<b><%=id %></b>

<%
if(check){
	out.println("는 이미 존재하는 ID입니다.<br><br>");
}else {
	out.println("는 사용 가능합니다..<br><br>");
}
%>

</div>
</body>
</html>