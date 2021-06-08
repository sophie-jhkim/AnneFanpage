<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<style type="text/css">
.mania{
 width: 1000px;
 margin: 50px auto;
 text-align:center;
 font-family: 'Noto Sans KR', sans-serif;
}
.mania th{
 background-color:#cfd8b0;
 padding:10px 0;
font-weight : 500;
border:1px solid grey;
border-bottom:2px solid #214d0d;
}
.mania td{
 border:1px solid grey;
 padding : 5px 0 ;
 font-size: 14px;
}
</style>
<script type="text/javascript">
function change(){
	var langSelect = document.getElementById("rate");
	
	var level = document.formm.rate.selected;
	var cnt=0;
	for(var i = 0; i <document.formm.rate.length; i++){
		cnt++;
	}
		
	
// 	var level = document.formm.rate.selected;
// 	var cnt = 0;
// 	for(var i = 0; i <document.formm.id.length; i++){
// 		if(document.formm.rate[i].selected ==true){
// 			cnt++;
// 		}
// 	}
// 	document.formm.action = "Level.do";
}

function moveurl(url){
	if(url == ""){
		location.href='../AnneAdmin/Manias.do'+url;
	}else{
	location.href='../AnneAdmin/Manias_useyn.do?useyn='+url;
	}
}
</script>
<title>고객관리</title>
</head>
<body>
<jsp:include page="AdminHeader.jsp"/>

<form action="Level.do" method="post" name="formm">
<!-- <form action="" method="post" name="formm"> -->
<table class="mania">
<tr>
<th>Name</th><th>ID </th><th>Pwd</th><th>Nick</th><th>Phone</th>
<th>E-mail</th><th>Address</th><th>AD</th><th>Level</th><th>indate</th>
<th style="width: 85px;">
		<select name="useyn" style="width: 80px; font-size: 15px;" onchange="moveurl(this.value)">
				<option value="">-----</option>
				<option value="y">활동회원</option>
				<option value="n">탈퇴회원</option>
		</select>
</th>
</tr>
<c:forEach var="mania" items="${mania}">
<tr>
<td>${mania.name}</td>
<td style="">
<input type=hidden name="id" value="${mania.id}"/>
<a href="AdminManiaDetail.do?id=${mania.id}" style="color: #214d0d; font-weight:500; font-size:15px; text-decoration:underline ">${mania.id}</a></td><td>${mania.pwd}</td>
<td>${mania.nick}</td><td>${mania.phone}</td><td style="text-align:left; text-indent:10px">${mania.email}</td>
<td style="text-align:left; text-indent:10px">${mania.address}</td><td>${mania.ad}</td>
<td>
${mania.rate}
</td>
<td><fmt:formatDate value="${mania.indate}" type="date"/></td> 
<c:if test="${mania.useyn=='n'}">
<td style="background-color:#d93240">
${mania.useyn}
</td>
</c:if>
<c:if test="${mania.useyn=='y'}">
<td>
${mania.useyn}
</td>
</c:if>
</tr>
</c:forEach>
<tr>
<td colspan="11" style="border:none; text-align:right">
<!-- <input type="button" value="변경" onclick="change()"> -->
<!-- <input type="submit" value="변경"> -->
</td>

</tr>
</table>
</form>
<div class="bin" style="height:510px;"></div>


<jsp:include page="../AnneCustom/footer.jsp"/>
</body>
</html>