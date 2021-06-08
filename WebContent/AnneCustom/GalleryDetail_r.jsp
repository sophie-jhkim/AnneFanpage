<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Gallery" %>
<%@ page import="dto.PReply" %>
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
		document.photoform.action ="gallery_delete.do";
		document.photoform.submit();
	}
	
}
function r_delete(){
	var check = confirm("정말 삭제하시겠습니까?");
	if(check == true){
		document.reply.action ="../AnneCustom/preply_delete.do";
		document.reply.submit();
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

.photo{
width:900px; 
margin:auto; 
font-size: 20px; 
text-align:center;
font-family: 'Noto Sans KR', sans-serif;
}
.photo th{
text-align : left;
font-weight : bold;
}
.photo td{
padding: 10px 10px; 
}
.photo th input{
border:none; 
font-size:16px; 
outline:none;
width : 60px; 
height : 30px;
}
.photo .imgwrap{
width : 900px;
text-align:center;
margin:auto;
}
.photo .imgwrap img{
margin: 0 auto;
display : inline-block;
max-width: 100%;
margin-bottom: 20px;
}
.reply{
width:900px; 
margin:auto; 
font-family: 'Noto Sans KR', sans-serif;
}
.reply td{
padding: 10px; 
}
.buttons{
width: 150px;
margin-top:20px; 
float:right;
}
.bin{
height : 300px;
}
.photo span{
font-size: 15px;
color : grey;
padding-left: 10px;
}
.photo h4{
 font-size : 30px;
 font-weight : 700
}
</style>
<title>Gallery Detail</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<article>

<div class="title">
<h3>Gallery</h3>
</div>
<form action="../AnneCustom/preply_insert.do" method="post" name="photoform">

<table class="photo">

	<tr>
		 <th colspan="6"  style="padding:10px 0; text-align : left; border-bottom:1px solid grey"><h4>${photo.title}</h4><br>
		 <span><fmt:formatDate value="${photo.indate}" type="date"/>  조회 ${photo.hit}  </span>
		 <c:choose>
			<c:when test="${sessionScope.mania !=null}">
			<c:set var="mania" value="${sessionScope.mania}" />
		<div class="buttons">
		<c:if test="${mania.id==photo.id ||mania.id=='admin' }" var="admin">
			<input type='button' value='삭제' style="background : #214d0d; color : #ffffff; 
				" onclick="go_delete()">
			<input type='button' value='수정' onclick="location.href='gallery_update.do?gseq=${photo.gseq}'"
				style="background : #d93240; color : #ffffff; ">
		</c:if>
		</div>
		</c:when>
		</c:choose>
		 </th>
	</tr>	
	<tr>
		<td colspan="6" style="text-align: left; height: 200px; padding-top: 20px;">
		<div class="imgwrap">
		<img src="../AnneCustom/photo/${photo.img}" style=""/>
		</div>
		<div style="white-space:pre-line; line-height:25px; margin-bottom:50px;">
		<input type="hidden" value="${photo.gseq}" name="gseq">
		<c:out value="${photo.content}"/>
		</div>
		</td>
	</tr>
	</table>
	</form>
	
	<form action="../AnneCustom/preply_update.do?rseq=${reply.rseq}" method="post" name="reply">
	<table class="reply">
	<tr>
		<td style="padding:10px 0; text-align:left; border-bottom:1px solid grey; font-size:18px;  font-weight:700" colspan="6">댓글</td>
	</tr>
	<c:forEach var="rep" items="${rep}">
	<tr style="border-bottom: 1px solid grey; ">
		<th colspan="2" style="width:100px; text-align:center; vertical-align:middle;">${rep.nick }</th>
		<td colspan="4" style="text-align:left; ">
		<input type="hidden" value="${rep.rseq}" name="rseq">
		<div style="white-space:pre-line; line-height:20px;">
		<c:out value="${rep.content}"/>
		</div>
		<br><p style="font-size: 15px; color : grey;float:left;">
		<fmt:formatDate value="${rep.indate}" type="date" pattern="yyyy.MM.dd HH:mm"/></p>
		<div class="" style="float:right">
		<c:if test="${mania.id==rep.id ||mania.id=='admin'}" var="admin">
			<input type='button' value='삭제' style=" " onclick="r_delete()"> 
			<input type='button' value='수정' onclick="../AnneCustom/preply_update.do?rseq=${rep.rseq}" style="">
		</c:if>
		</div>
		</td>
	</tr>
	</c:forEach >
	<tr>
		<th colspan="2" style="vertical-align:middle;">${mania.nick}
		<input type="hidden" value="${mania.nick}" name="nick">
		<input type="hidden" value="${mania.id}" name="id">
		<input type="hidden" value="${reply.gseq}" name="gseq">
		</th>
		<td colspan="3"><textarea rows="4" cols="80" name="content" style="font-size: 16px; border:1px solid grey; font-family: 'Noto Sans KR', sans-serif;" name="reply" >
		${reply.content}</textarea> </td>
		<td style="vertical-align:middle;"><input type="submit" value="수정" style="background : #214d0d; color : #ffffff; 
					width : 70px; height : 30px; border:none; font-size:16px; outline:none;"></td>
	</tr>
</table>
	<div class="clear"></div>
</form>


</article>



<div class="bin"></div>

<jsp:include page="footer.jsp"/>
</body>
</html>