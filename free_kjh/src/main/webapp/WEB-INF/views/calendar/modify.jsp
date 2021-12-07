<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<div align=center>
		<header>학생 정보 수정</header>
		<form name=modifyForm action="/myweb/calendar/modify" method="post">
		<table>
			<tr><th>아이디</th><td><input type="text" name="id" readonly value="${user.id}"></td></tr>
			<tr><th>비밀번호</th><td><input type="text" name="passwd" value="${user.passwd}"></td></tr>
			<tr><th>이름</th><td><input type="text" name="username" value="${user.username}"></td></tr>
			<tr><th>전화번호</th><td><input type="text" name="pnum" value="${user.pnum}"></td></tr>
			<tr><th>직업</th><td><input type="text" name="job" value="${user.job}"></td></tr>
		</table><br>
			<input type="submit" name="submit" value="최종 수정">
			<input type="reset" name="reset" value="다시작성">
		</form>
	</div>
</body>
</html>