<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
	<form method="post" action="/views/board/insert"></form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>게시시간</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="7">게시물이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.biNum }</td>
				<td><a href="/board/view?biNum=${board.biNum}">${board.biTitle }</a></td>
				<td>${board.uiName }</td>
				<td>${board.credat }</td>
				<td>${board.cretim }</td>
				<%--<td><a href="/board/update?biNum=<%=board.get("biNum")%>"><button
							type="button">수정</button></a></td> 
				<td><a href="/board/delete?biNum=<%=board.get("biNum")%>"><button
							type="button">삭제</button></a></td>--%>
			</tr>
		</c:forEach>
	</table>
	<button onclick="goPage('/views/board/insert')">글쓰기</button>

	<script>
		function goPage(url) {
			location.href = url;
		}
	</script>
</body>
</html>