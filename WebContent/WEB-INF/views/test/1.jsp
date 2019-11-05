<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<c:set var="test" value="나나나" scope="page"/><%--디폴트가 page--%>
<%--키값은 test 밸류는 나나나--%>
${test}<br>
 
 <%@ include file="/WEB-INF/views/common/header.jspf" %>
<%
pageContext.setAttribute("msg","난 페이지");//작은 순, 여기서만 사용할 수 있음
request.setAttribute("msg","난 리퀘스트");//키값이 똑같다고해도 서로 침범하는건 아님,이동했을때 리퀘스트가 나옴
session.setAttribute("msg","난 세션");//리퀘스트(응답이 끝났을때)를 거치고 왔으니까 세션이 나옴
//session.invalidate();//세션 무효화
application.setAttribute("msg","난 어플리케이션");//같은 키값으로 했을때 제일 작은 영역부터 찾아냄
//RequestDispatcher rd = request.getRequestDispatcher("/views/test/2");
//rd.forward(request,response);
%>
${msg}