<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="">
		<div class="center">
			<input class="c_input" placeholder="아이디를 입력해주세요" type="text"
				name="id">
		</div>
		<div class="right">
			<button class="b_right" onclick="idCheck(this.from.id.value)">
				<span>중복확인</span>
			</button>
		</div>
	</form>
</body>
</html>

<script type="text/javascript">
	function idCheck(id) {
		if (id == "") {
			alert("아이디를 입력해주세요");
			document.regForm.id.focus();
		} else {
			url = "member.do?cmd=idCheck&id=" + id;
			window.open(url, "post", "width=300, height=150");
		}
	}
</script>