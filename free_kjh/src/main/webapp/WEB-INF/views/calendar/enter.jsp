<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 등록</title>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- custom -->
<link href="../resources/css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript">
$(function(){
    $('.datetimepicker').appendDtpicker({'locale':'ko'});
});
</script>

</head>
<body>
	<c:if test="${msg=='false' }">
		<script>
			alert("로그인 해주세요.");
			location.href('home');
		</script>
	</c:if>
	<div class="group" id="popupGroup">
		<div class="group-head">
			<h1 class="zTree-h1">일정 추가</h1>
		</div>
		<div class="group-body">
			<form id="scheduleData" method="post" action="/myweb/calendar/enter">
				<div class="top">
				</div>
				<div class="domain">
					<h3 class="zTree-h3">시작</h3>
				</div>
			
					<input class="datetimepicker" id="startDate" type="text" name="sDate">
				
				<div class="domain">
					<h3 class="zTree-h3">종료</h3>
				</div>
				<div class="domain">
					<input class="datetimepicker" id="endDate" type="text" name="eDate">
				</div>
				<div class="domain">
					<h3 class="zTree-h3">메모</h3>
				</div>
				<div class="domain">
					<textarea class="memo" id="memo" name="content" rows="5" cols="20"
						placeholder="100글자까지 입력 가능합니다"></textarea>
				</div>
				<input type="submit" value="등록">
			</form>
		</div>
	</div>
</body>
</html>