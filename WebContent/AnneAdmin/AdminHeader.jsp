<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Mania"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%
	Mania mania = (Mania) session.getAttribute("mania");
%>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<style type="text/css">
#util{
width:100%;
height: 35px; 
background-color: rgba( 0, 0, 0, 0.5 );
color: #ffffff; 
font-family: 'Noto Sans KR', sans-serif;
}
#util ul{
 line-height:35px;
}
#util ul li{
float:left;
padding : 0 10px;
}
#menu{
background-color: #14370b; 
color: #ffffff; 
height: 155px;
width:100%;
font-family: 'Noto Sans KR', sans-serif;
margin:auto;
text-align:center;
}
#menu .menuwrap{
width:680px;
margin:auto;
height:45px;
}
#menu ul{
line-height:35px;
}
#menu ul li{
font-family: 'Noto Sans KR', sans-serif;
float:left;
padding : 0 52px;
font-size: 18px;
}
a{
text-decoration:none;
color: #ffffff; 
}
</style>
<title>Admin header</title>
</head>
<div id="util">
	<ul style="float:right; margin-right:5%;">
		<c:choose>
			<c:when test="${sessionScope.mania !=null}">
			<li>
				<c:set var="mania" value="${sessionScope.mania}" />
				${mania.nick}님 <a href="../AnneCustom/logout.do" style="">Logout</a>
				<c:if test="${mania.id=='admin'}" var="admin">
				<a href="../AnneAdmin/Manias.do" style="color: white; padding:2px 10px; 
				background-color:#d93240; border-radius: 5px; text-decoration: none;">관리자 페이지</a>
				</c:if>
			</li>
			</c:when> 
		<c:otherwise>
			<li><a href="../AnneCustom/login.do" >Login</a></li>
			<li><a href="../AnneCustom/join.do" >Join</a></li>
<!-- 			<li><a href="javascript:addMania();" >Join</a></li> -->
			<li><a href="../AnneCustom/login.do">Mypage</a></li>
			<li><a href="../AnneCustom/login.do">Cart</a></li>
		</c:otherwise>
		</c:choose>
	</ul>
</div>
<div id="menu">
	<div id="logo" style="text-align:center;"><a href="../AnneCustom/index.do">
		<img alt="logo" src="../AnneAdmin/AnnImage/home/logo.png" style="width:140px; margin: 20px auto;">
	</a></div>
	<div class="menuwrap">
	<ul style="float:left; margin:auto;" >
		<li><a href="../AnneAdmin/AdminGoods.do?page=1">상품관리</a></li>
		<li><a href="../AnneAdmin/Manias.do">고객관리</a></li>
		<li><a href="../AnneAdmin/AdminOrders.do">주문관리</a></li>
		<li><a href="../AnneAdmin/QnA_list.do">QnA</a></li>
	</ul>
	</div>
</div>
</html>