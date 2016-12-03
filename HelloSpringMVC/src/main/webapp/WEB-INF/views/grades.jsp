<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>모든 과목 정보 보기</title>
</head>
<body>
	<h1>모든 과목 정보 보기</h1>
	<table border=1>
		<tr>
			<td>연도</td>
			<td>학기</td>
			<td>과목코드</td>
			<td>이름</td>
			<td>구분</td>
			<td>학점</td>
		</tr>
		<c:forEach var="offer" items="${offers}">

			<tr>
				<td>${offer.year}</td>
				<td>${offer.semester}</td>
				<td>${offer.code}</td>
				<td>${offer.name}</td>
				<td>${offer.division}</td>
				<td>${offer.grade}</td>
			</tr>

		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath }/">메인메뉴로</a>
</body>
</html>