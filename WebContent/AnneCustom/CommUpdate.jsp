<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="dto.Mania" %>
 <%@ page import="dto.Board" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
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
margin: 100px 0 50px 20px;
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
<title>게시글 수정하기</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<article style="width: 900px; margin: auto">

<div class="title">
<h3>게시글 수정하기</h3>
</div>
<form action="board_update.do?bseq=${board.bseq}" method="post">

<table class="board">
	<tr style="border-bottom:1px solid grey">
		 <th style="padding:10px 0; text-align : left; width: 70px; font-weight:700; color: grey">제목 :</th>
		 <td colspan="4"><h4>
		 	<input type="text" name="subject" class="sub" style="font-size: 19px; width:700px; border:none; outline:none;"
		 	value="${board.subject}">
		 	</h4></td>
	</tr>	
	<tr>
		<td colspan="5" style="text-align: left; height: 200px; padding-top: 20px;">
		<div style="white-space:pre-line;">
		<textarea name="content"
		style="width: 100%; height: 412px; outline:none; font-size: 16px; padding:10px;">
		<c:out value="${board.content}"></c:out></textarea>
		</div>
		</td>
	</tr>
	<tr>
		<td colspan="5">
		<div class="buttons">
		<input type='button' value='취소' style="background : white ; color : #214d0d; 
				width : 60px; height : 30px; border:2px solid #214d0d; font-size:16px; outline:none;" onclick="location.href='board.do'">
			<input type='button' value='삭제' style="background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
			<input type='submit' value='수정' onclick="alert('수정 성공')"
				style="background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
<%-- 		<input type="text" value="${board.bseq}" name="bseq"> --%>
<%-- 		<input type="text" value="${board.id}" name="id"> --%>
<%-- 		<input type="text" value="${board.nick}" name="nick">	 --%>
<%-- 		<input type="text" value="${mania.nick}" name="nick">	 --%>
		<input type="hidden" value="${board.bseq}" name="bseq">
		<input type="hidden" value="${mania.id}" name="id">
		<input type="hidden" value="${mania.nick}" name="nick">
		</div>
		</td>
	</tr>

</table>
	<div class="clear"></div>
	<input type="hidden" value="${board.bseq}" name="bseq">
</form>


</article>



<div class="bin"></div>

<jsp:include page="footer.jsp"/>



</body>
</html>