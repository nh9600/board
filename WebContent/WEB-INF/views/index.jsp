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
안녕하세요~<br>
<%
if(user==null){

%>
<a href="/views/user/login"><button>로그인</button></a>
<%
}else{
%>
<a href="/board/list"><button>게시판 가기</button></a>
<a href="/users/logout"><button>로그아웃</button></a>
<%
}
%>
</body>
</html>