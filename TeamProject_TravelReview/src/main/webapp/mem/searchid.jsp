<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link href="ect_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>

<form action="searchidProc.jsp" name="idproc" method="post" onsubmit="return searchId(),">
	<div class="search-header">
		<h2>아이디 찾기</h2>
	</div>

	<div class="r-border"></div>

	<div class="loginDivForm">

		<div>
			<input type="text" name="name" value="" placeholder="이름을 입력해주세요">
		</div>
	
		<div>
			<input type="text" name="email" value="" placeholder="이메일을 입력해주세요">
		</div>

		<div>
			<input class="bt3" type="submit" value="ID찾기"> 
			<input class="bt3" type="button" value="취소"
				onclick="javascript:window.location.href='member.do?cmd=login'">
		</div>

	</div>

</form>

</body>
</html>