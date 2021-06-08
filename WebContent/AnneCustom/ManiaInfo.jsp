<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="dto.Mania" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<script type="text/javascript">
function go_delete(){
	var check= confirm("탈퇴 후 한달동안 같은 정보로 재가입할 수 없습니다. \n정말 탈퇴하시겠습니까?");
	if(check == true){
		document.info.action="expired.do";
		alert("탈퇴되었습니다. \n이용해주셔서 감사합니다.");
		document.info.submit();
	}
	
}</script>
<style type="text/css">
body{
font-family: 'Noto Sans KR', sans-serif;
}
.bin{
height : 400px;
}
.title{
width : 900px;
margin:auto;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 50px 0 50px 20px;
padding: 3px 20px;
}
.info{
	height: 340px;
	width : 500px;
	margin:auto;
	border-right : none;
	border-left : none;
}
.info tr{ 
padding: 20px 0;
font-size:17px;
}
.info th{
font-size:18px;
width: 25%;
vertical-align: middle;
border:1px solid #214d0d;
background-color:#cfd8b0;
border-left : none;
border-right : none;
}
.info td{
vertical-align: middle;
border:1px solid #214d0d;
text-indent : 15px;
border-left : none;
border-right : none;
}
input{
font-size:18px;
height: 25px;
}
.buttons{
width: 400px; 
margin:auto;
padding-top:20px
}
textarea{
width : 220px; 
height:70px;
font-size: 18px;
}
</style>
<title>회원정보</title>
</head>
<body>
<jsp:include page = "header.jsp"/>
<jsp:include page = "QnANavigation.jsp"/>
<div class="title">
<h3>Personal Info</h3>
</div>
	<div style="width: 600px; margin:auto;">
		<form action='update.do?id=${mania.id}' method='post' name='info'>
	<table class="info">
		<tr><th>ID</th>
			<td colspan="2">${mania.id}</td>
		</tr>
		<tr><th>Name</th>
			<td colspan="2">${mania.name}</td>
		</tr>
		<tr><th>Nick name</th>
			<td colspan="2">${mania.nick}</td>
		</tr>
		<tr><th>Level</th>
			<td colspan="2">${mania.rate}</td>
		</tr>
		<tr><th>Email</th>
			<td>${mania.email}</td>
		</tr>
		<tr><th>Address</th>
			<td colspan="2">${mania.address}</td>
		</tr>
		
		<tr><th>Phone</th>
			<td colspan="2">${mania.phone}</td>
		</tr>
		<tr><th>Join date</th>
			<td colspan="2"><c:out value="${fn:substring(mania.indate, 0, 10)}"/></td>
		</tr>
	</table>
		<input type="hidden" name="id" value="${mania.id}">
		<div class="buttons">
		<input type='button' value='탈퇴' onclick="go_delete()"
				style="background : #214d0d; color : #ffffff; 
				width : 100px; height : 35px; border:none; font-size:17px; outline:none;">
			<div style="float : right">
			<input type='submit' value='수정' style="background : #d93240; color : #ffffff; 
					width : 100px; height : 35px; border:none; font-size:17px; outline:none;">
			</div>
			</div>
		</form>
	</div>
<div class="bin" style=""></div>


<jsp:include page = "footer.jsp"/>
</body>
</html>