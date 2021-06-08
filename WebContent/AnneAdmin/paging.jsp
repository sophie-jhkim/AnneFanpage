<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="dto.Paging"%>
    <%@ page import="dto.Goods" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style type="text/css">
body{
    text-align:center;
}
#paging{
    font-size: 12pt;
    font-family: 'Noto Sans KR', sans-serif;
/*     position:absolute; */
/*     left:50%; */
/*     bottom:-320px; */
/*     margin-left:-30px */
}
#paging a{
 color:#c8c8c8;
}
</style>
<title>paging</title>
</head>
<body>
<div id="paging">
<!-- 1~10까지 있는 페이지의 페이징 -->
<c:url var="action" value=""/>
<c:if test="${param.prev}">
    <a href="AdminGoods.do?page=${param.beginPage-1}">prev</a>
</c:if>
<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
     <c:choose> 
         <c:when test="${param.page==index}"> 
           [${index}] 
         </c:when> 
         <c:otherwise> 
            <a href="AdminGoods.do?page=${index}">[${index}]</a>
        </c:otherwise> 
    </c:choose> 
</c:forEach>
<c:if test="${param.next}">
    <a href="AdminGoods.do?page=${param.endPage+1}">next</a>
</c:if>
</div>



</body>
</html>