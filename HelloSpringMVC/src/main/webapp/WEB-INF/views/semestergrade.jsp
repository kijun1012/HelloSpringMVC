<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학기별 이수 학점 조회</title>
</head>
<body>
<h1>학기별 이수 학점 조회</h1>
<table border=1>
<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수학점</td>
			<td>상세보기</td>
		</tr>
	<c:forEach var="semester" items="${allgradebysemester}">
		<tr>
			<td>${semester.year}</td>
			<td>${semester.semester}</td>
			<td>${semester.grade}</td>
			<td><a href="${pageContext.request.contextPath }/semestergradedetail?year=${semester.year}&semester=${semester.semester}">링크</a></td>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/">메인메뉴로</a>
</body>
</html>