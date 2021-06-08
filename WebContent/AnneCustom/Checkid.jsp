<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="dto.Mania" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<% Mania mania = (Mania)request.getAttribute("mania"); %>

<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style>
body{
text-align : center;
font-family: 'Noto Sans KR', sans-serif;
}
p{
font-size:18px;
font-family: 'Noto Sans KR', sans-serif;
}
input{
font-size: 16px;
height : 30px; 
border:none; 
outline:none;
padding: 0 10px;
background:#214d0d; 
color:#fff;
font-family: 'Noto Sans KR', sans-serif;

}
</style>
<meta charset="UTF-8">
<title>ID Check Page</title>
</head>
<body><br><p>
	<%
				
			  if(mania != null){
// 			  if(mania != null){
	%>
		<%= mania.getId() +"는 사용할 수 없는 아이디 입니다."%><p>
		<input type="button" value="닫기" onClick="window.close()"/>
	
	<%
		  }else{
	%>
	
	<%= request.getParameter("id") +"는 사용할 수 있는 아이디 입니다."%><p>
	<input type="button" value="사용하기" onClick="window.close()"/>
	<% pageContext.setAttribute("ok", "ok"); %>
	<input type="hidden" value="${ok }" name="ok">
	<%
		  }

	 %>



</body>
</html>