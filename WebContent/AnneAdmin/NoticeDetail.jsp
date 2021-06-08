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
<script type="text/javascript">
function go_delete(){
	var check = confirm("정말 삭제하시겠습니까?");
	if(check == true){
		document.notice.action ="Notice_delete.do";
		document.notice.submit();
	}
	
}
</script>
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
margin: 100px 0 50px 20px;
padding: 3px 20px;
}

.board{
width:900px; 
margin:auto; 
font-size: 20px; 
text-align:center;
font-family: 'Noto Sans KR', sans-serif;
}
.board th{
text-align : left;
font-weight : bold;
}
.board td{
padding: 10px 10px; 
}
.buttons{
width: 150px;
margin-top:20px; 
float:right;
}
.bin{
height : 300px;
}
.board span{
font-size: 15px;
color : grey;
padding-left: 10px;
}
.board h4{
 font-size : 30px;
 font-weight : 700
}
</style>
<title>Community Detail</title>
</head>
<body>
<jsp:include page="../AnneCustom/header.jsp"/>
<article>

<div class="title">
<h3>Notice</h3>
</div>
<form action="수정으로 보내기??" method="post" name="notice">

<table class="board">
	<tr>
		 <th colspan="6"  style="padding:10px 0; text-align : left; border-bottom:1px solid grey"><h4>${notice.title}</h4><br>
		 <span><fmt:formatDate value="${notice.indate}" type="date"/>  조회 ${notice.hit}  </span>
		 <c:choose>
			<c:when test="${sessionScope.mania !=null}">
			<c:set var="mania" value="${sessionScope.mania}" />
		<div class="buttons">
		<c:if test="${mania.id=='admin'}" var="admin">
			<input type='button' value='삭제' style=" background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;" onclick="go_delete()">
			<input type='button' value='수정' onclick="location.href='Notice_update.do?nseq=${notice.nseq}'"
				style=" background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
		</c:if>
		</div>
		</c:when>
		</c:choose>
		 </th>
	</tr>	
	<tr>
		<td colspan="6" style="text-align: left; height: 200px; padding-top: 20px;">
		<div style="white-space:pre-line; line-height:23px;">
		<c:out value="${notice.content}"/>
		</div></td>
	</tr>

</table>
	<div class="clear"></div>
	<input type="hidden" value="${notice.nseq}" name="nseq">
</form>

</article>



<div class="bin"></div>

<jsp:include page="../AnneCustom/footer.jsp"/>
</body>
</html>