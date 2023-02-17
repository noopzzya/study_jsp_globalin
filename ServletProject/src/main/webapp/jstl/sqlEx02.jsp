<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<!-- Tomcat/context.xml(드라이브)의 값이 있을 경우 (JNDI 설정 된 경우) -->
<sql:setDataSource dataSource="jdbc/myoracle" var="ds" scope="application" />
	<sql:query var="rs" dataSource="${ds}" >
		SELECT * FROM TEMPMEMBER
	</sql:query>

<sql:update dataSource="${ds}">
	delete from tempmember where id=?
	<%-- update tempmember set passwd=? where id=? --%>
	<%-- <sql:param value="${3456}"/> --%>
	<sql:param value="${'CCCC'}"/>
</sql:update>

<table border="1">
<tr>
	<%-- 필드명 출력 --%>
	<c:forEach var="columnName" items="${rs.columnNames}">
		<th> <c:out value="${columnName}"></c:out> </th>
	</c:forEach>
	
	<%-- 레코드 수만큼 반복 실행 --%>
	<c:forEach var="row" items="${rs.rowsByIndex}">
	<tr>
		<%-- 레코드의 필드 수만큼 반복 실행 --%>
		<c:forEach var="column" items="${row}" varStatus="i">
			<td>
				<%-- 필드값이 존재한다면 --%>
				<c:if test="${!empty column}"> <%-- ${column != null} --%>
					<c:out value="${column}"/>
				</c:if>
				
				<%-- 필드값이 존재하지 않는다면 --%>
				<c:if test="${column == null}">
					&nbsp;
				</c:if>
			</td>
		</c:forEach>
	</tr>
	</c:forEach>
	
</tr>
</table>
</body>
</html>