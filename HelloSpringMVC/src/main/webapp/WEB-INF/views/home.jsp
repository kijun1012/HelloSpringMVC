<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<p> <a href="${pageContext.request.contextPath}/grades">모든 과목 정보 보기</a>

<p> <a href="${pageContext.request.contextPath}/semestergrade">학기별 이수 학점 조회</a>
<p> <a href="${pageContext.request.contextPath}/divisiongrade">이수 구분별 학점 조회</a>
<p> <a href="${pageContext.request.contextPath}/registercourse">수강신청하기</a>
<p> <a href="${pageContext.request.contextPath}/checkregister">수강 신청 조회</a>
</body>
</html>
