<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Board" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<style type="text/css">
article{
width:900px; 
margin:auto; 
}
.board{
width:900px; 
margin:auto; 
font-size: 20px; 
}
.board td{
padding : 5px 0;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 50px 0 50px 20px;
padding: 3px 20px;
}
.board .buttons{
text-align: center;
}
.clear{
 height: 100px;
}
body{
font-family:'Noto Sans KR', sans-serif;
}
textarea{
font-family:'Noto Sans KR', sans-serif;
}
</style>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<article style="width: 900px; margin: auto">
<div class="title">
<h3>게시글 작성하기</h3>
</div>

<form action="board_insert.do" method="post">

<table class="board">
	<tr style="border-bottom:1px solid grey">
		 <th style="padding:10px 0; text-align : left; width: 70px; font-weight:700; color: grey">제목 :</th>
		 <td colspan="4"><h4>
		 	<input type="text" name="subject" class="sub" style="font-size: 19px; width:700px; border:none; outline:none;">
		 	</h4></td>
	</tr>	
	<tr>
		<td colspan="5" style="text-align: left; height: 200px; padding-top: 20px;">
		<textarea name="content" id="content" 
		style="width: 100%; height: 412px; outline:none; font-size: 16px; padding:10px;" placeholder="내용을 입력하세요">
		</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="5">
		<div class="buttons">
<%-- 		 <c:choose> --%>
<%-- 			<c:when test="${sessionScope.mania !=null}"> --%>
<%-- 			<c:set var="mania" value="${sessionScope.mania}" /> --%>

<%-- 		<c:if test="${mania.id==board.id}" var="admin"> --%>
<!-- 			<input type='button' value='삭제' style="border-radius: 5px; background : #214d0d; color : #ffffff;  -->
<!-- 				width : 60px; height : 30px; border:none; font-size:16px; outline:none;"> -->
<%-- 			<input type='button' value='수정' onclick="location.href='board_update.do?bseq=${board.bseq}'" --%>
<!-- 				style="border-radius: 5px; background : #d93240; color : #ffffff;  -->
<!-- 				width : 60px; height : 30px; border:none; font-size:16px; outline:none;"> -->
<%-- 		<input type="hidden" value="${board.bseq}" name="bseq"> --%>
<%-- 		</c:if> --%>
		<input type="hidden" value="${mania.id}" name="id">
		<input type="hidden" value="${mania.nick}" name="nick">

<%-- 		</c:when> --%>
<%-- 		<c:otherwise > --%>
			<input type='button' value='취소' onclick="location.href='board.do'" style="background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
			<input type='submit' value='등록'
				style="background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
<%-- 		</c:otherwise>		 --%>
<%-- 		</c:choose> --%>
		</div>
		</td>
	</tr>

</table>
	<div class="clear"></div>
</form>


</article>

<div class="bin"></div>

<jsp:include page="footer.jsp"/>
</body>
</html>