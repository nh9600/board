<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/views/board/insert">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
				<%
					if (request.getAttribute("list") == null) {
						out.println("<tr><td colspan=\"4=\">게시물이 없습니다.</td></tr>");
					} else {
						List<Map<String, String>> boardList = (List<Map<String, String>>) request.getAttribute("list");
						for (Map<String, String> board : boardList) {
				%>
				<tr>
				<td><%=board.get("biNum")%></td>
				<td><%=board.get("biTitle")%></td>
				<td><%=board.get("uiNum")%></td>
				<td><%=board.get("credat")%></td>
				<td><a href="/board/update?biNum=<%=board.get("biNum")%>"><button type="button">수정</button></a></td>
				<td><a href="/board/delete?biNum=<%=board.get("biNum")%>"><button type="button">삭제</button></a></td>
				</tr>
			<%
				}
				}
			%>
			<tr>
				<th colspan="6"><button>글쓰기</button></th>
		</table>
	</form>
</body>
</html>