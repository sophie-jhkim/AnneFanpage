<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
   <%@ page import="dto.Goods" %>
   <%@ page import="dto.Board" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   
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

.goods h3{
font-family: 'Noto Sans KR', sans-serif;
font-weight: 700;
width: 200px;
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 50px 20px;
padding: 3px 20px;
}

.board{
 width: 900px;
 margin:auto;
 margin-top:50px;
 border-top: 2px solid #214d0d; 
 text-align :center;
  border-bottom: 2px solid #214d0d; 
 font-family: 'Noto Sans KR', sans-serif;
}
</style>
<meta charset="UTF-8">
<title>검색 결과 </title>
</head>
<body>

<jsp:include page = "../AnneCustom/header.jsp"/>

<div class="goods">
<h3> 상품 검색 결과 </h3>
<c:choose>
<c:when test= "${goods.size()==0}">
<h4 style="color:#d93240; text-align:center; font-size:25px;"> 검색 결과가 없습니다 </h4>
</c:when>
<c:otherwise>
	<table style="margin: auto;" class="list">
	<tr>
<c:forEach var="goods" items="${goods}" begin="0" end="3">
			<td><a href="ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<img src="../AnneAdmin/AnnImage/goods/${goods.img}" width="180px"/><br>
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
			<img src="../AnneAdmin/AnnImage/goods/${goods.img}" width="180px"/><br>
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
			<img src="../AnneAdmin/AnnImage/goods/${goods.img}" width="180px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
</tr>

	</table>



</c:otherwise>
</c:choose>	
</div>
<!-- <div class="board2"> -->
<!-- <h3> 상품 검색 결과 </h3> -->
<%-- <c:choose> --%>
<%-- <c:when test= "${board.size()==0}"> --%>
<!-- <h4 style="color:#d93240; text-align:center; font-size:25px;"> 검색 결과가 없습니다 </h4> -->
<%-- </c:when> --%>
<%-- <c:otherwise> --%>

<!-- <form action=""> -->
<!-- <table class="board"> -->
<!-- <tr> -->
<!-- <th class="no"></th><th class="title2"> 제목 </th><th>작성자 </th> <th> 작성일 </th> <th>조회수</th> -->
<!-- </tr> -->
<%-- <c:forEach var="bo" items="${board}"> --%>
<!-- <tr> -->
<%-- <td>${bo.bseq}</td> --%>
<!-- <td class="title2" style="text-align:left"> -->
<%-- <a href="board_detail.do?bseq=${bo.bseq}" style="color: black">${bo.subject}</a></td><td>${bo.nick}</td> --%>
<%-- <td><fmt:formatDate value="${bo.indate}" type="date"/></td> <td>${bo.hit}</td> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </table> -->
<!-- </form> -->
<%-- </c:otherwise> --%>
<%-- </c:choose>	 --%>
<!-- </div> -->
<div style="height:200px;"></div>
<jsp:include page = "../AnneCustom/footer.jsp"/>
</body>
</html>