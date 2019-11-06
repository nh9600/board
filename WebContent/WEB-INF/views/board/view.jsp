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
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${board.biNum}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.biTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.biContent}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.uiName}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.credat}</td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td>${board.credat}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="goPage('/board/list')">리스트가기</button> <c:if
					test="${user.uiNum==board.uiNum}">
					<button onclick="goPage('/board/update?biNum=${board.biNum}')">수정하기</button>
					<a href="/board/delete?biNum=${board.biNum}"><button >삭제하기</button></a>
				</c:if>
			</th>
		</tr>
	</table>
	<script>
		function goPage(url) {
			location.href = url;
		}
	</script>
</body>
</html>