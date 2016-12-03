<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel = "stylesheet" type="text/css" href = "${pageContext.request.contextPath}/resources/css/main.css">
<title>이수 구분별 학점 조회</title>
</head>
<body>
	<h1>이수 구분별 학점 조회</h1>
	<table border=1><tr>
	<c:forEach var="sum" items="${gradebydivision}">
		
			<td >${sum.division}</td>
		
	</c:forEach>
	</tr>
	<tr>
	<c:forEach var="sum" items="${gradebydivision}">
		
			<td >${sum.grade}</td>
		
	</c:forEach>
	</tr>
	</table>
	<a href="${pageContext.request.contextPath }/">메인메뉴로</a>
</body>
</html>