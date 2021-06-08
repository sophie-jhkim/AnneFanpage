<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.QnA" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style type="text/css">
body{
font-family: 'Noto Sans KR', sans-serif;
}
.title{
width : 900px;
margin:auto;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 20px 20px;
padding: 3px 20px;
}

.qna{
 width: 900px;
 margin:auto;
 margin-top:50px;
 border-top: 2px solid #214d0d; 
 text-align :center;
  border-bottom: 2px solid #214d0d; 
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
.title2 a{
width: 500px;
text-overflow:ellipsis;
white-space: nowrap;
overflow:hidden;
word-break:normal;
display : inline-block;
}
.bin{
height : 450px;
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
<jsp:include page="header.jsp"/>
<jsp:include page="QnANavigation.jsp"/>

<div class="title">
<h3>QnA</h3>
</div>
<div class="btn">
<input type="button" value="문의하기" onclick="location.href='QnA_insert.do'"
style="background : #214d0d; color : #ffffff; 
width : 100px; height : 32px; border:none; font-size:16px; outline:none; float:right;">
</div>
<form action="">
<c:choose>
<c:when test= "${qna.size()==0}">
<div style="width:900px; margin:auto; text-align:center">
<h3 style="color:#d93240; text-align:center; font-size:18px;  font-family: 'Noto Sans KR', sans-serif; font-weight:500; "> 
문의한 내역이 없습니다. </h3>
</div>
</c:when>
<c:otherwise>
<table class="qna">
<tr>
<th class="no">no.</th><th class="title2"> 제목 </th><th>문의한 날짜 </th> <th> 진행상태 </th>
</tr>
<c:forEach var="qna" items="${qna}">
<tr>
<td>${qna.qseq}</td>
<td class="title2" style="text-align:left">
<a href="QnA_detail.do?qseq=${qna.qseq}" style="color: black">${qna.subject}</a></td>
<td><fmt:formatDate value="${qna.indate}" type="date"/></td> 
<td>
<c:choose>
		<c:when test="${qna.rep == 1}">
			답변대기			
		</c:when>
		<c:otherwise>
			답변완료
		</c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</table>

</c:otherwise>
</c:choose>
</form>

<div class="bin" style="height:700px"></div>


<jsp:include page="footer.jsp"/>

</body>
</html>