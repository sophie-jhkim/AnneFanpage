<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Goods" %>
<%@ page import="dto.Paging"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<script type="text/javascript">
function go_goods_delete(){
 	var check = document.formm.pseq.checked;
//  	var num = document.formm.pseq.length;
	var cnt=0;
	for(var i =0; i<document.formm.pseq.length; i++){
		if(document.formm.pseq[i].checked == true){
			cnt++;
		}
	}
	if(cnt <= 0){ //여기 cnt==0일때로 해주면 1개남아있을때 인식을 못함
		alert("삭제할 항목을 선택해 주세요.");
	}else{
		var rechk = confirm(cnt+"개의 상품을 삭제하시겠습니까?");
		if(rechk == true){
		document.formm.action ="../AnneAdmin/goods_delete.do";
		document.formm.submit();
		}
	}
	
}

</script>
<title>Goods List</title>
<style type="text/css">
#goodsList{
font-family: 'Noto Sans KR', sans-serif;
 width: 1000px;
 margin: 50px auto;
 text-align:center;
 
}
#goodsList tr{
border-bottom: solid 1px grey;
}
#goodsList th{
 border-bottom : 2px solid #214d0d;
 background-color:#cfd8b0;
 padding : 10px 0;
 font-weight : 500;
}
#goodsList td{
padding : 7px;
text-align : center;
vertical-align: middle;
height: 60px;
font-size: 15px;
}
#goodsList td .imgwrap{
width : 60px;
height : 60px;
text-align:center;
overflow:hidden;
/* display:table-cell; */
vertical-align:middle;
position:relative;
}
#goodsList td .imgwrap img{
margin: 0 auto;
max-width: 100%;
position:absolute;
vertical-align:middle; 
text-align:center;
margin-left:-30px;
}
.paging{
/* position:absolute; */
/* left:50%; */
/* margin-left:-30px; */
/* bottom:-180px; */
}
</style>
</head>
<body>
<jsp:include page="AdminHeader.jsp"/>
<article style="posotion:relative;">
<form name="formm" method="post" action="../AnneAdmin/GoodsChange.do">
	<div style="width:900px; margin: 50px auto; padding-bottom:5px; text-align:right;">
		<input type="button" value="상품 추가" style="background : #214d0d; color : #ffffff; 
		width : 100px; height : 32px; border:none; font-size:16px; outline:none; float:right;" onclick="location.href='goods_insert.do'">
	</div>
	<table id=goodsList style="width:900px; margin-top:50px auto;">
	<tr>
		<th>no.</th><th style="width:45%">상품명</th><th>가격</th> <th>입고날짜</th><th>재고</th><th>best</th><th></th>
	</tr>	
	<c:forEach var="goods" items="${goods}" >
	<tr style="border-bottom:1px solid darkgrey;">
		<td>${goods.pseq}</td>
		<td>
		<a href="../AnneAdmin/ShopDetail.do?pseq=${goods.pseq}" 
		style="text-decoration:none; color:black;float:left; ">
		<div class="imgwrap">
		<img src="../AnneAdmin/AnnImage/goods/${goods.img}" />
		</div>
		<span style="position: absolute; margin-left: 50px;margin-top:-35px">${goods.name}</span> 
		</a>
		</td>
		<td><fmt:formatNumber value="${goods.price2}" type="currency"/></td>
		 <td><fmt:formatDate value="${goods.indate}" type="date"/></td> 
		 <td>
		<c:if test="${goods.useyn=='y'}">y</c:if>
		<c:if test="${goods.useyn=='n'}">n</c:if>
		 </td>
		 <td>
		 <c:if test="${goods.bestyn=='y'}">y</c:if>
		<c:if test="${goods.bestyn=='n'}">n</c:if>
		 </td>
		 <td><input type="checkbox" name="pseq" value="${goods.pseq}">
		 <input type="hidden" name="pseq" value="${goods.pseq}">
		 </td>
	</tr>
	</c:forEach>
	
	<tr style="border-bottom:none;">
	<td colspan="5" style="text-indent:50px">
		<div class="paging" style="padding-left:80px">
		<jsp:include page="paging.jsp">
		<jsp:param value="${paging.page}" name="page"/>
   			 <jsp:param value="${paging.beginPage}" name="beginPage"/>
    		<jsp:param value="${paging.endPage}" name="endPage"/>
    		<jsp:param value="${paging.prev}" name="prev"/>
    		<jsp:param value="${paging.next}" name="next"/>
		</jsp:include>
		</div>
		</td>
	<td colspan="2" style="text-align:right; border:none; padding-top:0; ">
<!-- 	<input type="submit" value="수정" style="" > -->
	<input type="button" value="선택 삭제" style="vertical-align:top;" onclick="go_goods_delete()"></td>
	</tr>
	
</table>

<jsp:include page="../AnneCustom/footer.jsp"/>
</form>
</article>
</body>
</html>