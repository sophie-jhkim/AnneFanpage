<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
   <%@ page import="dto.Goods" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<style type="text/css">
.goods{
width : 900px;
margin : auto;
overflow :hidden;
font-family: 'Noto Sans KR', sans-serif;
}
body{
font-family: 'Noto Sans KR', sans-serif;
}
.goods image{
width : 150px;
margin:auto;
}
.goods p{
font-size: 18px;
padding : 10px 0;
}
.goods span{
text-align : center;
margin : auto;
color :  #14370b;
}
.goods td{
padding:30px; 
text-align:center;
}
.goods a:hover{
opacity: 0.6;
/* background-color: rgba( 255, 255, 255, 0.5 ); */
}
.cate{
margin:100px 0 50px 0;
}
.cate h2{
font-family: 'Noto Sans KR', sans-serif;
font-size : 30px;
font-weight: 500;
padding:10px;
color: #14370b;
text-align:center;
width:180px;
margin:auto;
border-bottom: 3px solid #d93240;
}
</style>
<meta charset="UTF-8">
<title> Shop </title>
</head>
<body>

<jsp:include page = "../AnneCustom/header.jsp"/>
<jsp:include page = "ShopNavigation.jsp"/>

<div class="cate">
<c:if test="${param.kind==1}"><h2>Books</h2></c:if>
<c:if test="${param.kind==2}"><h2>Stationary</h2></c:if>
<c:if test="${param.kind==3}"><h2>Clothes</h2></c:if>
<c:if test="${param.kind==4}"><h2>others</h2></c:if>
<c:if test="${param.kind==5}"><h2 style="width: 300px">Phone Accessories</h2></c:if>
</div>
<div class="goods">
	<table style="margin: auto;" class="list">
	<tr>
<c:forEach var="goods" items="${goods}" begin="0" end="3">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}"  width="150px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
 	</tr>
	<tr>
<c:forEach var="goods" items="${goods}" begin="4" end="7">
			<td>
			<a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}"  width="150px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
</c:forEach>
</tr>
	<tr>
<c:forEach var="goods" items="${goods}" begin="8" end="11">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}" width="150px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
</tr>
	<tr>
<c:forEach var="goods" items="${goods}" begin="12" end="15">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}" width="150px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
</tr>
	<tr>
<c:forEach var="goods" items="${goods}" begin="16" end="19">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}" width="150px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
</tr>
	</table>
</div>
<div style="height:200px;"></div>

<jsp:include page = "../AnneCustom/footer.jsp"/>
</body>
</html>