<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Notice" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community</title>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style type="text/css">
body{
font-family: 'Noto Sans KR', sans-serif;
}
.title{
width : 900px;
margin:auto;
font-family: 'Noto Sans KR', sans-serif;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 20px 20px;
padding: 3px 20px;
}

.board{
 width: 900px;
 margin:auto;
 margin-top:50px;
 border-top: 2px solid #214d0d; 
 border-bottom: 2px solid #214d0d; 
 text-align :center;
 font-family: 'Noto Sans KR', sans-serif;
}
table th{
 border-bottom : 2px solid #214d0d;
 padding : 10px 0;
 font-weight : bold;
}
table tr{
border-bottom : 1px solid grey;
}
table td{
	 padding : 10px 0;
}
.title2{
 width : 62%;
}
.bin{
height : 550px;
}
.btn{
 width: 900px;
 margin:auto;
 padding-top:30px;
}
.no{
 width : 50px;
}
</style>
</head>
<body>
<jsp:include page="../AnneCustom/header.jsp"/>
<div class="title">
<h3>Notice</h3>
</div>
	<c:choose>
		<c:when test="${sessionScope.mania !=null}">
			<c:set var="mania" value="${sessionScope.mania}" />
		<div class="btn">
		<c:if test="${mania.id=='admin'}" var="admin">
		<input type="button" value="글쓰기" onclick="location.href='Notice_insert.do'"
		style="background : #214d0d; color : #ffffff; 
		width : 100px; height : 32px; border:none; font-size:16px; outline:none; float:right;">
		</c:if>
		</div>
		</c:when>
	</c:choose>
<form action="">
<table class="board">
<tr>
<th class="no"></th><th class="title2"> 제목 </th> <th> 작성일 </th> <th>조회수</th>
</tr>
<c:forEach var="no" items="${notice}">
<tr>
<td>${no.nseq}</td>
<td class="title2" style="text-align:left">
<a href="Notice_detail.do?nseq=${no.nseq}" style="color: black">${no.title}</a></td>
<td><fmt:formatDate value="${no.indate}" type="date"/></td> <td>${no.hit}</td>
</tr>
</c:forEach>
</table>
</form>

<div class="bin"></div>


<jsp:include page="../AnneCustom/footer.jsp"/>

</body>
</html>