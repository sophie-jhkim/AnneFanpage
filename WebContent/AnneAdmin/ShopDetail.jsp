<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
   <%@ page import="dto.Goods" %>
   <%@ page import="dto.Mania" %>
   <%@ page import="dto.Orders" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<style type="text/css">
input{
font-size: 15px;
 height : 35px; 
 border:none; 
 outline:none;
}
.head{
width: 800px;
margin:auto;
padding: 100px 0 30px 0;
}
.head h2{
font-size: 30px;
font-weight:700;
font-family: 'Noto Sans KR', sans-serif;
padding: 15px;
border-bottom: 5px dotted grey;
}
.name{
font-family: 'Noto Sans KR', sans-serif;
font-size: 22px;
font-weight: 500;
color: #d93240;
}
.detail{
font-family: 'Noto Sans KR', sans-serif;
margin-bottom: 100px;
}

.detail td p{
font-size: 18px;
line-height:25px;
}
.detail td p span{
color :  #14370b;
font-weight: 500;
}
</style>
<script type="text/javascript">
function go_order(){
	document.formm.action="../AnneCustom/order_direct.do";
	document.formm.submit();
	
}

function go_delete(){
	var rechk = confirm("상품을 삭제하시겠습니까?");
	if(rechk == true){
	document.formm.action ="../AnneAdmin/goods_delete.do";
	document.formm.submit();
	}
}
</script>
<title>Shop Detail</title>
</head>
<body>
<jsp:include page = "../AnneCustom/header.jsp"/>
<jsp:include page = "ShopNavigation.jsp"/>

<div class="head">
<h2>item detail</h2>
</div>

<h2 style="padding:50px; margin:auto; text-align:center;" class="name">
${goods.name}
</h2>


<form action="../AnneCustom/cart_insert.do" method="post" name="formm">
	<table style="width:900px; margin: auto; margin-bottom: 100px;" class="detail">
	<tr>
		<td>
		<c:if test="${mania.id=='admin'}" var="admin">
			<input type='button' value='삭제' style=" background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;" onclick="go_delete()">
			<input type='button' value='수정' onclick="location.href='../AnneAdmin/goods_update.do?pseq=${goods.pseq}'"
				style=" background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
		</c:if>
		
		</td>
	</tr>
	<tr>
			<td style="padding:20px; margin:auto;" rowspan="2">
			<div class="img" style="text-align:center;">
			<image src="AnnImage/goods/${goods.img}" style="width:400px"/>
			</div>
			</td>
			<td style="vertical-align:middle; padding:20px;">
			<h2 style="font-size: 19px; color : #181818">  ${goods.name}</h2>
			<br>
			<P>
			<span>가격 : ${goods.price2} 원</span></P>
			<br><P style="background-color: #d93240; font-size: 16px; width:120px; color:white; text-align:center; margin-top:20px;">상품 상세 정보 : </p>
			<div style="white-space:pre-line;">
			<p style="font-size:16px;"><c:out value="${goods.content}"/></p>
			</div>
			
			</td>
		
	</tr>
	<tr>
			<td style="padding:20px;">
			<input type="hidden" name="pseq" value="${goods.pseq}">
			<input type="hidden" value="${mania.id}" name="id"><br>
			<p>수량 <input type="number" name="quantity" value="1" style="width: 40px; margin: 50px 10px; border:1px solid black; height:25px;"> </p>
		<c:if test="${goods.useyn=='n'}"><p style="color:red;">품절 상품입니다.</p>
	<input type="button" value="바로구매"  onclick="" style=" background :#fff ; color : #d93240; width : 90px; border:2px solid #d93240;" disabled>
	<input type="submit" value="장바구니 담기" style="background : #d93240; color : #fff; 
				width : 125px;" disabled>
	<input type="reset" value="취소" class="cancle" style="background : #214d0d; color : #fff; 
				width : 60px;">
		</c:if>
		
			<c:if test="${goods.useyn=='y'}">
			<input type="hidden" name="pseq" value="${goods.pseq}">
			<input type="hidden" value="${mania.id}" name="id">
	<input type="button" value="바로구매" onclick="go_order()" style=" background :#fff ; color : #d93240; width : 90px; border:2px solid #d93240;" >
	<input type="submit" value="장바구니 담기" style="background : #d93240; color : #fff; 
				width : 125px;">
	<input type="reset" value="취소" class="cancle" style="background : #214d0d; color : #fff; 
				width : 60px;">
				</c:if>
	<td>
	</tr>
	</table>
</form>


<jsp:include page = "../AnneCustom/footer.jsp"/>
</body>
</html>