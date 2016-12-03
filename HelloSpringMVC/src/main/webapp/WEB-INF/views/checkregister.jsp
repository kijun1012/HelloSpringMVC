<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>수강 신청 조회</title>
</head>
<body>
<h1>수강 신청 조회</h1>
	<table border=1px>
		<tr>
			<td>연도</td>
			<td>학기</td>
			<td>과목코드</td>
			<td>이름</td>
			<td>구분</td>
			<td>학점</td>
		</tr>
		<c:forEach var="register" items="${checkregister}">

			<tr>
				<td>${register.year}</td>
				<td>${register.semester}</td>
				<td>${register.code}</td>
				<td>${register.name}</td>
				<td>${register.division}</td>
				<td>${register.grade}</td>
			</tr>

		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath }/">메인메뉴로</a>
</body>
</html>