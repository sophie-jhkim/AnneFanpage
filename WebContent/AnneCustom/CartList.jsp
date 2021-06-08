<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Board" %>
<%@ page import="dto.Cart" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<script type="text/javascript">
function go_cart_delete(){
// 	var check = document.querySelectorAll('input:checkbox[name="cseq"]:checked');
 	var check = document.formm.cseq.checked
	var cnt=0;
	for(var i =0; i<document.formm.cseq.length; i++){
		if(document.formm.cseq[i].checked ==true){
			cnt++;
		}
	}
// 	if(document.formm.cseq.checked == false){
	if(cnt <= 0){ //여기 cnt==0일때로 해주면 1개남아있을때 인식을 못함
		alert("삭제할 항목을 선택해 주세요.");
	}else{
		document.formm.action ="cart_delete.do";
		document.formm.submit();
	}
	
}

</script>
<style type="text/css">
#buttons{
width:900px; 
margin:auto; 
margin-top:20px;
margin-bottom:100px;
text-align : center;
}
#cartLsit{
font-family: 'Noto Sans KR', sans-serif;
}
#cartLsit tr{
border-bottom: solid 1px grey;
}
#cartLsit th{
border-bottom : 2px solid #214d0d;
 padding : 10px 0;
 font-weight : 500;
}
#cartLsit td{
padding : 7px;
text-align : center;
vertical-align: middle;
}
#buttons input{
font-size: 15px;
height : 35px; 
border:none; 
outline:none;
}
.title{
width : 900px;
margin:auto;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 20px 20px;
padding: 3px 20px;
}
</style>
<title>장바구니</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="OrderNavigation.jsp"/>
<article>
<div class="title">
<h3>My Cart</h3>
</div>

<form name="formm" method="post" action="../AnneCustom/order_insert.do">
<c:choose>
<c:when test= "${cart.size()==0}">
<h3 style="color:#d93240; text-align:center"> 장바구니가 비었습니다. </h3>
</c:when>
<c:otherwise>

<table id=cartLsit style="width:900px;  margin:auto; border-top: 2px solid #214d0d; border-bottom:1px solid darkgrey; margin-top:50px;">
	<tr>
		<th>상품명</th> <th>수량</th> <th>가격</th> <th>주문일</th> <th></th>
	</tr>	
	<c:forEach var="cart" items="${cart}" >
	<tr style="border-bottom:1px solid darkgrey;">
		<td>
		<a href="../AnneAdmin/ShopDetail.do?pseq=${cart.pseq}" 
		style="text-decoration:none; color:black; line-height:100px; float:left;">
		<img src="../AnneAdmin/AnnImage/goods/${cart.img}" style="width:100px;float:left; margin-right:30px"/>
		${cart.pname}</a></td> 
		<td>${cart.quantity}</td> 
		<td><fmt:formatNumber value="${cart.price2*cart.quantity}" type="currency"/></td>
		 <td><fmt:formatDate value="${cart.indate}" type="date"/></td> 
		 <td><input type="checkbox" name="cseq" value="${cart.cseq}"></td>
	</tr>
	</c:forEach>
	<tr style="background-color:#cfd8b0">
	<th colspan="2"> 총 액</th> <th colspan="2" style="text-align:left"><fmt:formatNumber value="${totalPrice}" type="currency"/> </th> 
	<th><input type="button" value="삭제" style=" width : 50px; height : 27px; border:1px solid grey;" onclick="go_cart_delete()"></th>
	</tr>
	
</table>
<%-- 	<input type=hidden name="quantity" value="${cart.quantity}"/> --%>
<%-- 	<input type=hidden name="pseq" value="${cart.pseq}"/> --%>
</c:otherwise>
</c:choose>
	<div id=buttons>
		<input type="button" value="쇼핑계속하기" onclick="location.href='../AnneAdmin/Shop.do'" style="background:white; width:120px; border:2px solid #214d0d;">
		<c:if test="${cart.size() !=0 }">
		<input type="submit" value="전체 상품 주문하기" style="background:#d93240; color:#fff; width:160px;">
		</c:if>
	</div>
</form>
</article>

<div class="bin" style="height:300px"></div>
<jsp:include page="footer.jsp"/>
</body>
</html>