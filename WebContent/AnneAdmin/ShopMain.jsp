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
width : 1000px;
margin : auto;
overflow :hidden;
font-family: 'Noto Sans KR', sans-serif;
margin-top:50px;
}
body{
font-family: 'Noto Sans KR', sans-serif;
}
.goods td image{
width : 180px;
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
width:25%;
text-align:center;
}
.goods a:hover{
opacity: 0.6;
/* background-color: rgba( 255, 255, 255, 0.5 ); */
}
.best h3{
font-family: 'Noto Sans KR', sans-serif;
margin: auto;
text-align: center;
font-size: 25px;
font-weight: 700;
padding: 10px;
width: 200px;
border-bottom :  3px solid #d93240;
margin-top:50px;
}
.best{
margin-bottom:50px;
}
.goods h3{
font-family: 'Noto Sans KR', sans-serif;
margin: auto;
text-align: center;
font-size: 25px;
font-weight: 700;
padding: 10px;
width: 200px;
border-bottom :  3px solid #d93240;
margin-top:50px;
margin-bottom:20px;
}
</style>
<meta charset="UTF-8">
<title> Shop </title>
</head>
<body>

<jsp:include page = "../AnneCustom/header.jsp"/>
<jsp:include page = "ShopNavigation.jsp"/>

<div class="goods">
<h3> New Arrivals</h3>
	<table style="margin: auto;" class="list">
	<tr>
<c:forEach var="goods" items="${goods}" begin="0" end="3">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}" width="180px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
 	</tr>
	<tr>
<c:forEach var="goods" items="${goods}" begin="4" end="7">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="AnnImage/goods/${goods.img}" width="180px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
</tr>

	</table>
<section class="best">
	 <h3> Best Items</h3>
	 
	 	<table style="margin: auto;" class="list">
	<tr>
<c:forEach var="goods" items="${best}" begin="0" end="3">
			<td><a href="../AnneAdmin/ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="../AnneAdmin/AnnImage/goods/${goods.img}" width="180px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
 	</tr>
 	</table>
</section>
	
</div>
<!-- <h2 style="margin-top:100px; text-align:center;">BEST ITEMS</h2> -->
<!-- <hr> -->
<!-- 	<table style="margin: auto;"> -->
<!-- 	<tr> -->
<%-- <c:forEach var="bestList" items="${bestproList}" > <!-- IndexAction에서 선언해줬던 bestproList의 리스트를 가지고 와서 하나씩 풀어주기 --> --%>
		
<%-- 			<td style='padding:20px'><a style="text-decoration:none; color:black;" href="ShopController?command=detail&pseq=${bestList.pseq}" > --%>
<%-- 			<image src="product_images/${bestList.img}" width="250px" height="300px"><br> --%>
<%-- 			<center> --%>
<%-- 			No. ${bestList.pseq}<p style="font-size: 20px">  ${bestList.name}</p> --%>
<%-- 			<b>${bestList.price2} 원</b> --%>
<%-- 			</center> --%>
<!-- 			</a> -->
<!-- 			</td> -->
			
		
<%-- </c:forEach> --%>
<!-- </tr> -->
<!-- 	</table> -->

<jsp:include page = "../AnneCustom/footer.jsp"/>
</body>
</html>