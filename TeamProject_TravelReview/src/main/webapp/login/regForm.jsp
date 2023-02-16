<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style>

body {
	min-width: 1050px;
    margin-top: 50px;
    margin-bottom: 60px;
    background-color: rgb(255, 255, 255);
}

.join {
	margin-bottom: 50px;
    font-size: 28px;
    line-height: 35px;
    font-weight: 500;
    text-align: center;
    letter-spacing: -1px;
    color: #333;
}

div {
	width: 640px;
    margin: 0px auto;
}

.border {
}

.article {
	padding-bottom: 10px;
    border-bottom: 2px solid rgb(51, 51, 51);
    font-size: 12px;
    color: rgb(102, 102, 102);
    line-height: 17px;
    text-align: right;
}

.div1 {
	display: inline-flex;
    width: 100%;
    padding: 10px 20px;
}

</style>

</head>
<body>

<div>
	<div class="join">회원가입</div>
	
	<div class="border">
	
		<div class="article"><span>*</span>필수입력사항</div>
		
		<div>
		
			<div class="div1">
				<div>
					<label>아이디<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="아이디를 입력해주세요" type="text">
					</div>
				</div>
				<div>
					<button><span>중복확인</span></button>
				</div>
			</div>
			
			<div>
				<div>
					<label>비밀번호<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="비밀번호를 입력해주세요" type="password">
					</div>
				</div>
			</div>
			
			<div>
				<div>
					<label>비밀번호확인<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="비밀번호를 한번 더 입력해주세요" type="password">
					</div>
				</div>
			</div>
			
			<div>
				<div>
					<label>이름<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="이름을 입력해주세요" type="text">
					</div>
				</div>
			</div>
			
			<div>
				<div>
					<label>이메일<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="이메일을 입력해주세요" type="text">
					</div>
				</div>
			</div>
			
			<div>
				<div>
					<label>휴대폰<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="숫자만 입력해주세요" type="text">
					</div>
				</div>
			</div>
			
			<div>
				<div>
					<label>우편번호<span>*</span></label>
				</div>
				<div>
					<div>
						<input type="text">
					</div>
				</div>
				<div>
					<button><span>찾기</span></button>
				</div>
			</div>
			
			<div>
				<div>
					<label>주소<span>*</span></label>
				</div>
				<div>
					<div>
						<input type="text">
					</div>
				</div>
			</div>
			
			<div>
				<div>
					<label>상세주소<span>*</span></label>
				</div>
				<div>
					<div>
						<input placeholder="상세주소를 입력해주세요" type="text">
					</div>
				</div>
			</div>
			
		</div>		
		
	</div>


</div>

</body>
</html>