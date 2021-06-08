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
<script type="text/javascript">
function change(){
// 	var check = document.querySelectorAll('input:checkbox[name="cseq"]:checked');
 	var check = document.formm.odseq.checked
	var cnt=0;
	for(var i =0; i<document.formm.odseq.length; i++){
		if(document.formm.odseq[i].checked ==true){
			cnt++;
		}
	}
// 	if(document.formm.cseq.checked == false){
	if(cnt <= 0){ //여기 cnt==0일때로 해주면 1개남아있을때 인식을 못함
		alert("배송 상품을 선택해 주세요.");
	}else{
		document.formm.action ="AdminOrderState.do";
		document.formm.submit();
	}
	}
</script>
</head>
<body>
<jsp:include page="AdminHeader.jsp"/>

<article >
<div style="" class="title">
<h3>고객 주문 상세 정보</h3>
</div>

<form action="../AnneAdmin/AdminOrderState.do" method="post" name="formm">

<table class="orderLsit" style="width:900px; margin:auto; border-top: 2px solid #214d0d;margin-top:50px; ">
	<tr>
		<th>상품번호</th>
		<th width="40%">상품명</th> <th>수 량</th> <th>단가</th><th>결제금액</th> <th>주문일</th> <th>진행 상태</th>
	</tr>	
	<c:forEach var="order" items="${order}" >
	<tr style="border-bottom:1px solid darkgrey;">
		<td>${order.pseq}
		<input type=hidden name="oseq" value="${order.oseq}"/>
		<input type=hidden name="odseq" value="${order.odseq}"/>
		</td>
		<td  style="text-align:left; text-indent: 15px;">
		<a href="../AnneAdmin/ShopDetail.do?pseq=${order.pseq}" style="color:#d93240">${order.pname}</a></td> 
		<td>${order.quantity}</td> 
		<td><fmt:formatNumber value="${order.price2}" type="currency"/></td>
		<td><fmt:formatNumber value="${order.price2*order.quantity}" type="currency"/></td>
		 <td><fmt:formatDate value="${order.indate}" type="date"/></td> 
		 <td style="font-weight:500;">
		 <c:if test="${order.result=='1'}">주문 접수</c:if>
		 <c:if test="${order.result=='2'}">배송 완료</c:if>
		 <input type="checkbox" name="odseq" value="${order.odseq}">
<!-- 		 <select name="result" style="width:100px; font-size: 15px;" id="result"> -->
<%-- 		<option value="1" <c:if test="${order.result==1}">selected</c:if>>주문 접수</option> --%>
<%-- 		<option value="2" <c:if test="${order.result==2}">selected</c:if>>배송 완료</option> --%>
<!-- 	</select> -->
		 </td> 
	</tr>
	</c:forEach>
	
	<tr style="background-color: #cfd8b0">

	<th colspan="3">총 주문 금액</th>
	<th colspan="3"><fmt:formatNumber value="${totalPrice}" type="currency"/> </th> 
	<th>
<!-- 	<input type="submit" value="수정" style="" > -->
	<input type="button" value="선택 배송" style="" onclick="change()">
	</th>
	</tr>
	
</table>
</form>
	<div class="clear"></div>
	<div id="buttons" style="width:900px; margin:auto; margin-top:50px; text-align:center;">
		<input type="button" value="리스트" onclick="location.href='../AnneAdmin/AdminOrders.do'" style="background:white; width:120px; border:2px solid #214d0d;">
	</div>
</article>

<div class="bin" style="height:300px"></div>
<jsp:include page="../AnneCustom/footer.jsp"/>
</body>
</html>