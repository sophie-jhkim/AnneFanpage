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
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<style type="text/css">
article{
width:900px; 
margin:auto; 
}
.qna{
width:900px; 
margin:auto; 
font-size: 20px; 
font-family:'Noto Sans KR', sans-serif;
}
.qna td{
padding : 5px 0;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 50px 0 50px 20px;
padding: 3px 20px;
}
.qna h4{
 font-size : 30px;
 font-weight : 700
}
.qna .buttons{
text-align: center;
}
.qna span{
font-size: 15px;
color : grey;
padding-left: 10px;
}
.clear{
 height: 100px;
}
.bin{
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
<title>QnA 작성</title>
</head>
<body>
<jsp:include page="AdminHeader.jsp"/>
<article style="width: 900px; margin: auto">
<div class="title">
<h3>QnA 답변 하기</h3>
</div>


<form action="QnA_answer.do" method="post">

<table class="qna">
	<tr style="border-bottom:1px solid grey">
	<th colspan="6"  style="padding:10px 0; text-align : left; border-bottom:1px solid grey">
		 <h4>${qna.subject}</h4><br>
		 <span><fmt:formatDate value="${qna.indate}" type="date"/></span>
	</tr>	
	<tr>
		<td colspan="5" style="text-align: left; height: 200px; padding-top: 20px;">
		<div style="white-space:pre-line; line-height:23px;">
		<c:out value="${qna.content}"/>
		<input type="hidden" value="${qna.qseq}" name="qseq">
		</div>
		</td>
	</tr>
	<tr>
		<td style="padding:10px 0; text-align:left; border-bottom:1px solid grey; font-size:18px;  font-weight:700" colspan="6">답변</td>
	</tr>
	<tr>
	<td colspan="5" style="">
	<textarea rows="5" cols="90" name="reply" style="width: 95%; margin:auto;font-size: 16px; border:1px solid grey; font-family: 'Noto Sans KR', sans-serif;" name="reply" >${qna.reply}
		</textarea> 
	</td>
	</tr>
	
	<tr>
		<td colspan="5">
		<div class="buttons">
		<input type="hidden" value="${mania.id}" name="id">
		<input type="hidden" value="${mania.nick}" name="nick">

			<input type='button' value='취소' onclick="location.href='QnA_list.do'" style="background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
			<input type='submit' value='등록'
				style="background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">

		</div>
		</td>
	</tr>

</table>
	<div class="clear"></div>
</form>


</article>

<div class="bin"></div>

<jsp:include page="../AnneCustom/footer.jsp"/>
</body>
</html>