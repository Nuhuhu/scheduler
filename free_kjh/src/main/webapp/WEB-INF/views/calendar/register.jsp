<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="../resources/css/login.css">
</head>
<body>
<div align=center>
		<form name=registerForm action="/myweb/calendar/register" method="post" class="loginForm">
		<h1>회원 가입</h1>
		<div class="idForm">
        <input type="text" class="id" autofocus placeholder="아이디" name="id">
      </div>
      <div class="passForm">
        <input type="password" class="pw" placeholder="비밀번호" name="passwd">
      </div>
      <div class="idForm">
        <input type="text" class="id" autofocus placeholder="이름" name="username">
      </div>
      <div class="idForm">
        <input type="text" class="id" autofocus placeholder="핸드폰 번호" name="pnum">
      </div>
      <div class="idForm">
        <input type="text" class="id" autofocus placeholder="직업" name="job">
      </div>
		<dl>
			<dd><input type="submit" class="btn" name="submit" value="회원가입"></dd>
			<dd><input type="reset" class="btn" name="reset" value="다시 작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>