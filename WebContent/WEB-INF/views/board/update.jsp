<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="/board/update">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="bi_title" value="<%=board.get("biTitle")%>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="bi_content" ></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=user.get("uiNum")%></td>
			</tr>
			<tr>
				<th colspan="2"><button>작성완료</button>
		</table>
	</form>
</body>
</html>