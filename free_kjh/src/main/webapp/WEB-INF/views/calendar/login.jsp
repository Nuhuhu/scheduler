<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="../resources/css/login.css">
</head>
<body>
	<form action="/myweb/calendar/login" method="post" class="loginForm">
		<h2>로그인</h2>
		<div class="idForm">
			<input type="text" class="id" placeholder="ID" name="id">
		</div>
		<div class="passForm">
			<input type="password" class="pw" placeholder="PW" name="passwd">
		</div>
		<input type="submit" class="btn" name="submit" value="로그인">
		<c:if test="${msg == 'false'}">
			<p style="color: red;">로그인 실패! 아이디, 비밀번호를 확인하세요.</p>
		</c:if>
		<div class="bottomText">
			Don't you have ID? <a href="#">sign up</a>
		</div>
	</form>
</body>
</html>