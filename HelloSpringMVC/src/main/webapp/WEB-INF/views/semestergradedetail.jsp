<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학기별 이수학점 세부 조회</title>
</head>
<body>
	<h1>학기별 이수학점 세부 조회</h1>
	<table border=1>
		<tr>
			<td>연도</td>
			<td>학기</td>
			<td>과목코드</td>
			<td>이름</td>
			<td>구분</td>
			<td>학점</td>
		</tr>
		<c:forEach var="select" items="${selectsemester}">

			<tr>
				<td>${select.year}</td>
				<td>${select.semester}</td>
				<td>${select.code}</td>
				<td>${select.name}</td>
				<td>${select.division}</td>
				<td>${select.grade}</td>
			</tr>

		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/semestergrade">뒤로가기</a>
	<a href="${pageContext.request.contextPath }/">메인메뉴로</a>
</body>
</html>