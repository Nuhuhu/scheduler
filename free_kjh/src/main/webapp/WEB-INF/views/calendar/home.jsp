<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.kpu.myweb.domain.SchedulVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
List<SchedulVO> list = (ArrayList<SchedulVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<link href='../resources/css/style.css' rel='stylesheet' />
<script type="text/javascript" src='../resources/js/main.js'></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>

<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	
	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
		},
		locale: "ko",
		navLinks: true, // can click day/week names to navigate views
		businessHours: true, // display business hours
		editable: true,
		selectable: true,
		events: [
<%if (list != null) {
	for (int i = 0; i < list.size(); i++) {
		SchedulVO vo = (SchedulVO) list.get(i);
		String sdate = vo.getSDate();
		String edate = vo.getEDate();%>	{
	title : '<%=vo.getContent()%>',
	start : "<%=sdate.replace(' ', 'T')%>",
	end : "<%=edate.replace(' ', 'T')%>",
	memo : "<%=vo.getContent()%>"
	},
<%}
}%>
			{
				title : 'default',
				start : "1800-01-01",
				end : "1800-01-01"
			}
		],
		eventClick:function(event){
			if(event,url){
				alert(event.title,"width=700,height=600");
				window.open(event.url);
				return false;
			}
		}
	});

	calendar.render();
});
</script>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="home">일정 관리페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample03" aria-controls="navbarsExample03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarsExample03">
			<ul class="navbar-nav mr-auto">
				<c:if test="${user == null }">
					<li class="nav-item active"><a class="nav-link"
						href="/myweb/calendar/login">로그인 </a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/myweb/calendar/register">회원가입 </a></li>
				</c:if>
				<c:if test="${user!=null }">
					<li class="nav-item active"><a class="nav-link" href="#">${user.getId()}님</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/myweb/calendar/logout">로그아웃 </a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/myweb/calendar/list">회원정보보기 </a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/myweb/calendar/modify">회원정보수정 </a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/myweb/calendar/delete">회원탈퇴 </a></li>
				</c:if>
			</ul>
		</div>
	</nav>

	<div id='calendar' style="position: relative">
		<button class="add-button" type="button"
			onclick="location.href='enter'">일정 등록</button>

	</div>

	<div align="center"><header > 일정 목록 </header>
		<table>
			<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					SchedulVO vo = (SchedulVO) list.get(i);
			%>
			<tr >
				<td ><%=vo.getContent()%></td>
				<%
				if (vo.getSDate().equals(vo.getEDate())) {
				%>
				<td><%=vo.getSDate()%></td>
				<%
				} else {
				%>
				<td><%=vo.getSDate()%> ~ <%=vo.getEDate()%></td>
				<%
				}
				%>
			<%
			}
			}
			%>
		</table>
	</div>
</body>
</html>