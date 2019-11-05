<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str" value="abc" />
	<c:if test="${str eq'abc'}">
str은 abc네<br>
	</c:if>
	<c:if test="${str ne'abc'}">
str은 abc가 아니네<br>
	</c:if>

	<c:forEach var="변수" items="아이템">
		<tr>
			<td align="right" bgcolor="#ffffff">
			${str}<br>
			</td>
		</tr>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="10">
	${i}<br>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="10" step="2">
	${i}<br>
	</c:forEach>
	
	<c:forEach var="i" items="${intArray}" begin="2" end="4">
	[${i}]<br>
	</c:forEach>
</body>
</html>