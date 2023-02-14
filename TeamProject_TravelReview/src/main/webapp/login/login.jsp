<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<style>
    body {
        min-width: 1050px;
        margin-top: 150px;
        margin-bottom: 60px;
        background-color: #fff;
        
        font-weight: 800;
        font-size: 20px;
        line-height: 20px;
        text-align: center;
    }
    
    .loginform{
    	width: 340px;
        margin: 0 auto;
        letter-spacing: -0.6px;
        
        
    }
    
    form {
    	margin-top: 30px;
    	 
    	height: 54px;
        font-size: 14px;
    }
    
    input {
        position: relative;
        height: 48px;
    
    	width: 100%;
        height: 46px;
        padding: 0 11px 1px 15px;
        border-radius: 4px;
        border: 1px solid #ddd;
        font-weight: 400;
        font-size: 16px;
        line-height: 1.5;
        color: #333;
        outline: none;
        box-sizing: border-box;
    }
    
    .id-input:placeholder{
    	color: #ccc;
    }
    
    .spanBoard{
    	width: 1px;
        height: 10px;
        margin: 3px 6px 0;
        background-color: #333;
    }
    </style>

</head>
<body>

<div>로그인</div>
<div class="loginform">
	<form action="">
		<div>
			<input type="text" name="id" value="" placeholder="아이디를 입력해주세요">
		</div>
		
		<div>
			<input type="text" name="id" value="" placeholder="비밀번호를 입력해주세요">
		</div>
		
		<div>
			<a>아이디 찾기</a>
			<span class="spanBoard"></span>
			<a>비밀번호 찾기</a>
		</div>
		
		<div>
			<button>
				<span>로그인</span>
			</button>
			
			<button>
				<span>회원가입</span>
			</button>
		</div>
	</form>
</div>

</body>
</html>