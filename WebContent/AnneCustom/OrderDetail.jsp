<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="dto.Goods" %>
   <%@ page import="dto.Mania" %>
   <%@ page import="dto.Orders" %>
   <%@ page import="dto.Cart" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>주문 상세 정보</title>

<style type="text/css">
.orderList{
font-family: 'Noto Sans KR', sans-serif; 
text-align:center;
}
.orderLsit th{
font-family: 'Noto Sans KR', sans-serif;
border-bottom:2px solid #214d0d;
margin-top:0;
padding:10px 0;
font-weight : 500;
}
.orderLsit tr{
border-bottom:1px solid grey;
}
.orderLsit td{
padding : 10px;
text-align : center;
vertical-align: middle;
font-family: 'Noto Sans KR', sans-serif;
}
.title{
width : 900px;
margin:auto;
padding: 10px 0;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 0px 20px;
padding: 3px 20px;
}
#buttons input{
font-size: 15px;
height : 35px; 
border:none; 
outline:none;
}

</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="OrderNavigation.jsp"/>

<article >
<div style="" class="title">
<h3>주문 상세 정보</h3>
</div>

<c:choose>
<c:when test= "${order.size()==0}">
<h3 style="color:red; text-align:center"> 주문할 상품이 없습니다. </h3>
</c:when>
<c:otherwise>

<table class="orderLsit" style="width:900px; margin:auto; border-top: 2px solid #214d0d;margin-top:50px; ">
	<tr>
		<th>상품번호</th>
		<th width="40%">상품명</th> <th>수 량</th> <th>단가</th><th>결제금액</th> <th>주문일</th> <th>진행 상태</th>
	</tr>	
	<c:forEach var="order" items="${order}" >
	<tr style="border-bottom:1px solid darkgrey;">
		<td>${order.pseq}</td>
		<td  style="text-align:left; text-indent: 15px;">
		<a href="../AnneAdmin/ShopDetail.do?pseq=${order.pseq}" style="color:#d93240">${order.pname}</a></td> 
		<td>${order.quantity}</td> 
		<td><fmt:formatNumber value="${order.price2}" type="currency"/></td>
		<td><fmt:formatNumber value="${order.price2*order.quantity}" type="currency"/></td>
		 <td><fmt:formatDate value="${order.indate}" type="date"/></td> 
		 <td style="font-weight:500;">
		 <c:choose>
		<c:when test="${order.result=='1'}" >
		 주문 처리 중
		 </c:when>
		 <c:otherwise>
		 배송 완료
		 </c:otherwise>
		 </c:choose>
		 </td> 
	</tr>
	</c:forEach>
	
	<tr style="background-color: #cfd8b0">

	<th colspan="3">총 주문 금액</th>
	<th colspan="3"><fmt:formatNumber value="${totalPrice}" type="currency"/> </th> 
	<th></th>
	</tr>
	
</table>
</c:otherwise>
</c:choose>
	<div class="clear"></div>
	<div id="buttons" style="width:900px; margin:auto; margin-top:50px; text-align:center;">
		<input type="button" value="목록으로" onclick="location.href='../AnneCustom/order.do'" style="background:white; width:120px; border:2px solid #214d0d;">
	</div>
<!-- </form> -->
</article>

<div class="bin" style="height:400px"></div>
<jsp:include page="footer.jsp"/>
</body>
</html>