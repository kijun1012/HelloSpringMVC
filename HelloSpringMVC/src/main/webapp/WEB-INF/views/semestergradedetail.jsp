<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�б⺰ �̼����� ���� ��ȸ</title>
</head>
<body>
	<h1>�б⺰ �̼����� ���� ��ȸ</h1>
	<table border=1>
		<tr>
			<td>����</td>
			<td>�б�</td>
			<td>�����ڵ�</td>
			<td>�̸�</td>
			<td>����</td>
			<td>����</td>
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
	<a href="${pageContext.request.contextPath }/semestergrade">�ڷΰ���</a>
	<a href="${pageContext.request.contextPath }/">���θ޴���</a>
</body>
</html>