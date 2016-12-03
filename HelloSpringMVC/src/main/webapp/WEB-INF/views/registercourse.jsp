<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type="text/css" href = "${pageContext.request.contextPath}/resources/css/main.css">
<title>수강신청하기</title>
</head>
<body>
	<h1>수강신청하기</h1>
	<form method="get"
		action="${pageContext.request.contextPath }/doregistercourse">
		<table class="formtable">
			<tr>
				<td class="label">Code :</td>
				<td><input class = "control" name="code" type="text" /></td>
			</tr>
			<tr>
				<td class="label">Name :</td>
				<td><input class = "control" name="name" type="text" /></td>
			</tr>
			<tr>
				<td class="label">Division :</td>
				<td><input class = "control" name="division" type="text" /></td>
			</tr>
			<tr>
				<td class="label">Grade :</td>
				<td><input class = "control" name="grade" type="text" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class = "control" value="수강 신청" type="submit" /></td>
			</tr>
		</table>
	</form>
	
	<a href="${pageContext.request.contextPath }/">메인메뉴로</a>
</body>
</html>