<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Date time = new Date();//자바에 시간을 구하는 데이트객체 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//우리가 알고있는 시간으로 바꿔주는 심플데이트 
String sessionId = session.getId();
Long creTime = session.getCreationTime();
time.setTime(creTime);
String cre = sdf.format(time);
Long modTime = session.getLastAccessedTime();
time.setTime(modTime);
String mod = sdf.format(time);
%>
sessionId:<%=sessionId%><br>
creTime:<%=cre%><br>
modTime:<%=mod%><br>
</body>
</html>