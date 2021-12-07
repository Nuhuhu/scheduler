<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 목록</title>
</head>
<body>
	<div align=center>
		<header>학생 정보</header><br>
		<table>
		    <tr><th> 아이디 </th><td><c:out value="${user.id}"/></td></tr>
			<tr><th> 비밀번호 </th><td><c:out value="${user.passwd}"/></td></tr>
			<tr><th> 이름 </th><td><c:out value="${user.username}"/></td></tr>
			<tr><th> 전화번호 </th><td><c:out value="${user.pnum}"/></td></tr>
			<tr><th> 직업 </th><td><c:out value="${user.job}"/></td></tr>
		</table>
		<c:url value="/calendar/home" var="url"/><a href="${url}">홈으로</a>
	</div>
</body>
</html>