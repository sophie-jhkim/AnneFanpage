<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Board" %>
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
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 20px 20px;
padding: 3px 20px;
}
.title p{
 text-indent : 40px;
 font-family: 'Noto Sans KR', sans-serif;
}
.board{
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
height : 370px;
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
<div class="title">
<h3>Community</h3>
<p>비방, 욕설 등 부적절한 게시글을 관리자 권한으로 삭제 될 수 있음을 알려드립니다.</p>
</div>
<div class="btn">
<input type="button" value="글쓰기" onclick="location.href='board_insert.do'"
style="background : #214d0d; color : #ffffff; 
width : 100px; height : 32px; border:none; font-size:16px; outline:none; float:right;">
</div>
<form action="">
<table class="board">
<tr>
<th class="no"></th><th class="title2"> 제목 </th><th>작성자 </th> <th> 작성일 </th> <th>조회수</th>
</tr>
<c:forEach var="bo" items="${board}">
<tr>
<td>${bo.bseq}</td>
<td class="title2" style="text-align:left">
<a href="board_detail.do?bseq=${bo.bseq}" style="color: black">${bo.subject}</a></td><td>${bo.nick}</td>
<td><fmt:formatDate value="${bo.indate}" type="date"/></td> <td>${bo.hit}</td>
</tr>
</c:forEach>
</table>
</form>

<div class="bin"></div>


<jsp:include page="footer.jsp"/>

</body>
</html>