<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
   <%@ page import="dto.Gallery" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<style>
body{
font-family: 'Noto Sans KR', sans-serif;
}
.title{
width : 900px;
margin:auto;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 100px 0 50px 20px;
padding: 3px 20px;

}
.photo {
margin-bottom: 50px;
width: 1000px;
margin:auto;
}
.photo .list{
margin:auto;
/* table-layout:fixed; */
}
.list .imgwrap{
width : 300px;
height : 320px;
line-height:300px;
text-align:center;
overflow:hidden;
/* display:table-cell; */
vertical-align:middle;
position:relative;
border-radius: 20px;
margin: 1px;
}
.list .imgwrap img{
margin: 0 auto;
display : inline-block;
height: 100%;
position:absolute;
left:-35%
}
.list .imgwrap .inner{
position:absolute;
background-color: rgba(0, 0, 0, 0.3);
width: 100%;
height:100%;
text-align:left;
line-height:20px;
right:100%;
transition: all 0.3s;
}
.list .imgwrap:hover .inner{
right:0;
}
.list .imgwrap .inner p{
position:absolute;
left:15px;
bottom:15px;
font-family: 'Noto Sans KR', sans-serif;
font-size: 18px;
font-weight: 500;
color:white;
}
.list .imgwrap .inner p span{
font-size: 15px;
font-weight: 400;
}

</style>
<title>Gallery</title>
</head>
<body>

<jsp:include page = "../AnneCustom/header.jsp"/>

<div class="title">
<h3>Gallery</h3>
</div>
<section class="photo">
	<div style="width:900px; margin: 50px auto; padding-bottom:5px; text-align:right; ">
		<input type="button" value="업로드" style="background : #214d0d; color : #ffffff; 
		width : 100px; height : 32px; border:none; font-size:16px; outline:none; 
		float:right;" onclick="location.href='gallery_upload.do'">
	</div>
	 
	 	<table style="margin: auto;" class="list">
	 <tr>
<c:forEach var="photo" items="${photo}" begin="0" end="2">
			<td>
			<a href="gallery_detail.do?gseq=${photo.gseq}" style="text-decoration:none; color:black;">
			<div class="imgwrap">
			<img src="../AnneCustom/photo/${photo.img}" style=""/>
			<input type="hidden" value="${photo.gseq}">
			<div class="inner"><p>
			<span style="font-size:20px; font-weight:500">${photo.title}</span><br>
			${photo.nick}<br>
			<span><fmt:formatDate value="${photo.indate}" type="date"/></span></p></div>
			</div>
			</a>
			
			</td>
		
</c:forEach>
 	</tr>
	<tr>
<c:forEach var="photo" items="${photo}" begin="3" end="5">
			<td>
			<a href="gallery_detail.do?gseq=${photo.gseq}" style="text-decoration:none; color:black;">
			<div class="imgwrap">
			<img src="../AnneCustom/photo/${photo.img}" style=""/>
			<input type="hidden" value="${photo.gseq}">
			<div class="inner"><p>
			<span style="font-size:20px; font-weight:500">${photo.title}</span><br>
			${photo.nick}<br>
			<span><fmt:formatDate value="${photo.indate}" type="date"/></span></p></div>
			</div>
			</a>
			
			</td>
		
</c:forEach>
 	</tr>
 		<tr>
<c:forEach var="photo" items="${photo}" begin="6" end="8">
			<td>
			<a href="gallery_detail.do?gseq=${photo.gseq}" style="text-decoration:none; color:black;">
			<div class="imgwrap">
			<img src="../AnneCustom/photo/${photo.img}" style=""/>
			<input type="hidden" value="${photo.gseq}">
			<div class="inner"><p>
			<span style="font-size:20px; font-weight:500">${photo.title}</span><br>
			${photo.nick}<br>
			<span><fmt:formatDate value="${photo.indate}" type="date"/></span></p></div>
			</div>
			</a>
			
			</td>
		
</c:forEach>
 	</tr>
 	</table>
</section>
<div class="bin" style="height: 200px;"></div>

<jsp:include page = "../AnneCustom/footer.jsp"/>
</body>
</html>