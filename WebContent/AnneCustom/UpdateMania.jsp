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
height : 150px;
}
.title{
width : 900px;
margin:auto;
}
.title h3{
border-left : 5px solid green;
font-size:30px;
font-weight: bold;
margin: 100px 0 50px 20px;
padding: 3px 20px;
}
.info{
	height: 400px;
	width : 430px;
	margin:50px auto;
}
.info tr{ 
padding: 20px 0;
font-size:18px;
}

.info th{
font-size:20px;
width: 30%;
}
input{
font-size:18px;
height: 25px;
border:none;
}
.buttons{
width: 430px; 
margin:auto;
margin-top:10px
}
textarea{
width : 100%; 
height:70px;
font-size: 18px;
font-family: 'Noto Sans KR', sans-serif;
}
</style>
<title>회원정보</title>
</head>
<body>
<jsp:include page = "header.jsp"/>
<div class="title">
<h3>Personal Info</h3>
</div>
	<div style="width: 600px; margin:auto;">
		<form action='update.do?id=${mania.id}' method='post' name='info'>
	<table class="info">
		<tr><th>ID</th>
			<td colspan="2">${mania.id}</td>
		</tr>
		<tr><th>PW</th>
			<td colspan="2"><input type="text" name="pwd" value="${mania.pwd}" style="width:100%; border-bottom:1px solid grey;"></td>
		</tr>
		<tr><th>Name</th>
			<td colspan="2"><input type="text" name="name" value="${mania.name}"style="width:100%; border-bottom:1px solid grey;"></td>
		</tr>
		<tr><th>Nick name</th>
			<td colspan="2"><input type="text" name="nick" value="${mania.nick}"style="width:100%; border-bottom:1px solid grey;"></td>
		</tr>
		<tr><th>Email</th>
			<td><input type="text" name="email" value="${mania.email}" style="width:100%; border-bottom:1px solid grey;"></td>
		</tr>
		<tr><th style="vertical-align:top;">Address</th>
			<td colspan="2">
			<textarea name="address">${mania.address}</textarea>
			</td>
		</tr>
		
		<tr><th>Phone</th>
			<td colspan="2"><input type="text" name="phone" value="${mania.phone}" style="width:100%; border-bottom:1px solid grey;"></td>
		</tr>
		<tr><th>Join date</th>
			<td colspan="2"><c:out value="${fn:substring(mania.indate, 0, 10)}"/></td>
		</tr>
	</table>
		<input type="hidden" name="rate" value="${mania.rate}">
		<input type="hidden" name="id" value="${mania.id}">
		<div class="buttons">
		<input type='button' value='탈퇴' onclick="go_delete()"
				style="background :#fff ; color : #d93240; 
				width : 100px; height : 35px; border:3px solid #d93240; font-size:17px; outline:none; font-weight:bold">
			<div style="float : right;">
			<input type='reset' value='Reset' style="background : #214d0d; color : #ffffff; 
				width : 100px; height : 35px; border:none; font-size:17px; outline:none;">
			<input type='submit' value='수정' style="background : #d93240; color : #ffffff; 
					width : 100px; height : 35px; border:none; font-size:17px; outline:none;">
			</div>
			</div>
		</form>
	</div>
<div class="bin"></div>


<jsp:include page = "footer.jsp"/>
</body>
</html>