<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인</title>
<style>
.join_bt1 {
	height: 30px;
    border-radius: 3px;
    text-align: center;
    overflow: hidden;
    width: 80px;
    color: rgb(255, 255, 255);
    background-color: #2EA26B;
    border: 1px solid #2EA26B;
}

.join_bt2 {
	height: 30px;
    border-radius: 3px;
    text-align: center;
    overflow: hidden;
    width: 80px;
    color: rgb(255, 255, 255);
    background-color: #2EA26B;
    border: 1px solid #2EA26B;
}
</style>
</head>
<body>

<c:set var="flag" value="${flag}"/>

<br>
<div align="center">
<c:choose>
	<c:when test="${flag}">
		<b>회원가입을 진심으로 축하 드립니다.</b><br><br>
		<a href='member.do?cmd=login'>
			<input class="join_bt1" value="로그인">
		</a>
	</c:when>
	
	<c:otherwise>
		<b>다시 입력하여 주십시요.</b><br><br>
		<a href='member.do?cmd=regForm'>
			<input class="join_bt2" value="다시 입력">
		</a>
	</c:otherwise>
</c:choose>
</div>

</body>
</html>