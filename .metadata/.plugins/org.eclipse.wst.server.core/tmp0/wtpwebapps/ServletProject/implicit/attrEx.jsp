<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// pageContext Scope에 속성 저장(해당 JSP 페이지 내에서만 사용 가능한 속성을 의미)
	// Scope에 속성 저장
	pageContext.setAttribute("pageAttribute", "오예스");
	//pageContext.setAttribute("pageAttribute", "오예스", pageContext.PAGE_SCOPE);
	
	// request Scope에 속성 저장
	// application에서 request에 접근 가능한 것들을 의미
	request.setAttribute("requestAttibute", "o@yes.com");
	//pageContext.setAttribute("requestAttibute", "o@yes.com", pageContext.REQUEST_SCOPE);
	
	// session Scope에 속성 저장
	// 서블릿이나 JSP의 객체를 생존(클라이언트의 상태 정보)의 유지
	session.setAttribute("sessionAtrribute", "010-0000-0000");
	//pageContext.setAttribute("sessionAtrribute", "010-0000-0000", pageContext.SESSION_SCOPE);
	
	// application Scope에 속성 저장
	// 웹 어플리케이션 내의 모든 것
	application.setAttribute("applicationAttribute", "Global In");
	//pageContext.setAttribute("applicationAttribute", "Global In", pageContext.APPLICATION_SCOPE);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
	<li>이름:<%=pageContext.getAttribute("pageAttribute") %></li>
	<li>메일:<%=request.getAttribute("requestAttibute") %></li>
	<li>전화:<%=session.getAttribute("sessionAtrribute") %></li>
	<li>메일:<%=application.getAttribute("applicationAttribute") %></li>
</ul>

</body>
</html>