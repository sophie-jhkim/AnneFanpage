<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Orders" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Order List</title>
<style type="text/css">
#orderList{
font-family: 'Noto Sans KR', sans-serif;
 width: 1000px;
 margin: 50px auto;
 text-align:center;
}
#orderList tr{
border-bottom: solid 1px grey;
}
#orderList th{
 border-bottom : 2px solid #214d0d;
 background-color:#cfd8b0;
 padding : 10px 0;
 font-weight : 500;
}
#orderList td{
padding : 7px;
text-align : center;
vertical-align: middle;
font-size: 15px;
}

</style>
<script type="text/javascript">
function change(){
	document.formm.action="AdminOrderState.do";
	
	
	
}
</script>
</head>
<body>
<jsp:include page="AdminHeader.jsp"/>
<form action="../AnneAdmin/AdminOrderState.do" method="post" name="formm">
<table id="orderList">
	<tr>
		<th>no.</th><th>상품</th><th>주문 금액</th> <th>수량</th><th>주문자</th><th>주문날짜</th><th></th>
	</tr>	
	<c:forEach var="order" items="${order}" >
	<tr style="border-bottom:1px solid darkgrey;">
		<td>${order.oseq}
		<input type=hidden name="oseq" value="${order.oseq}"/>
		</td>
		<td>
		<a href="AdminOrderDetail.do?oseq=${order.oseq}" 
		style="text-decoration:none; color:black;float:left; color:#d93240 ">${order.pname}
		</a>
		</td>
		<td><fmt:formatNumber value="${order.price2}" type="currency"/></td>
		<td><fmt:formatNumber value="${order.quantity}" type="number"/></td>
		<td>${order.id}</td>
		 <td><fmt:formatDate value="${order.indate}" type="date"/></td> 
		 <td>
		<c:if test="${order.result=='1'}">주문 접수</c:if>
		<c:if test="${order.result=='2'}">배송 완료</c:if>

		 </td>
	</tr>
	</c:forEach>
	<tr style="border-bottom:none;">
	<td colspan="7" style="text-align:right; border:none;">
<!-- 	<input type="submit" value="수정" style="" > -->
<!-- 	<input type="button" value="수정" style="" onclick="change()"> -->
<!-- 	<input type="button" value="삭제" style="" onclick="go_cart_delete()"> -->
	</td>
	</tr>
	
</table>
</form>
<div class="bin" style="height:370px"></div>

<jsp:include page="../AnneCustom/footer.jsp"/>



</body>
</html>