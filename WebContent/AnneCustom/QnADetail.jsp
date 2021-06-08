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
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<script type="text/javascript">
function go_delete(){
	var check = confirm("정말 삭제하시겠습니까?");
	if(check == true){
		document.boardform.action ="../AnneCustom/QnA_delete.do";
		document.boardform.submit();
	}
}

</script>
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
margin: 100px 0 50px 20px;
padding: 3px 20px;
}

.qna{
width:900px; 
margin:auto; 
font-size: 20px; 
text-align:center;
font-family: 'Noto Sans KR', sans-serif;
}
.reply{
width:900px; 
margin:auto; 
font-family: 'Noto Sans KR', sans-serif;
}
.qna th{
text-align : left;
font-weight : bold;
}
.qna td{
padding: 10px 10px; 
}
.qna th input{
border:none; 
font-size:16px; 
outline:none;
width : 60px; 
height : 30px;

}
.buttons{
width: 150px;
margin-top:20px; 
float:right;
}
.bin{
height : 300px;
}
.qna span{
font-size: 15px;
color : grey;
padding-left: 10px;
}
.qna h4{
 font-size : 30px;
 font-weight : 700
}
</style>
<title>QnA Detail</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="QnANavigation.jsp"/>
<article>

<div class="title">
<h3>QnA</h3>
</div>
<form action="" method="post" name="boardform">

<table class="qna">

	<tr>
		 <th colspan="6"  style="padding:10px 0; text-align : left; border-bottom:1px solid grey">
		 <h4>${qna.subject}</h4><br>
		 <span><fmt:formatDate value="${qna.indate}" type="date"/></span>
		
		<div class="buttons">
		<c:if test="${qna.rep=='1'}">
			<input type='button' value='삭제' style="background : #214d0d; color : #ffffff; 
				" onclick="go_delete()">
			<input type='button' value='수정' onclick="location.href='QnA_update.do?qseq=${qna.qseq}'"
				style="background : #d93240; color : #ffffff; ">
		</c:if>
		</div>
		 </th>
	</tr>	
	<tr>
		<td colspan="6" style="text-align: left; height: 200px; padding-top: 20px;">
		<div style="white-space:pre-line; line-height:23px;">
		<c:out value="${qna.content}"/>
		<input type="hidden" value="${qna.qseq}" name="qseq">
		</div>
		</td>
	</tr>
</table>
</form>
<!-- <form action="" method="post" name="reply"> -->
<table class="reply">
	<tr>
		<td style="padding:10px 0; text-align:left; border-bottom:1px solid grey; font-size:18px;  font-weight:700" colspan="6">답변</td>
	</tr>
	<tr>
		<td colspan="3" style="">
		<div style="white-space:pre-line;">
<c:choose>
		<c:when test="${qna.rep == 1}">
			답변 처리중입니다.		
		</c:when>
		<c:otherwise>
		<c:out value="${qna.reply}"/>
		</c:otherwise>
</c:choose>
		</div>
		</td>
	</tr>
</table>
	<div class="clear"></div>



</article>



<div class="bin"></div>

<jsp:include page="footer.jsp"/>
</body>
</html>