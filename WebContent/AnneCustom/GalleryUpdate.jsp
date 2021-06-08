<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.Gallery" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>갤러리 업로드</title>
<style type="text/css">
article{
width:900px; 
margin:auto; 
}
.gallery{
width:900px; 
margin:auto; 
font-size: 20px; 
}
.gallery td{
padding : 5px 0;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 50px 0 50px 20px;
padding: 3px 20px;
}
.gallery .buttons{
text-align: center;
}
.clear{
 height: 100px;
}
body{
font-family:'Noto Sans KR', sans-serif;
}
textarea{
font-family:'Noto Sans KR', sans-serif;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<article style="width: 900px; margin: auto">
<div class="title">
<h3>갤러리 게시글 수정</h3>
</div>

<form action="gallery_update.do?gseq=${photo.gseq}" method="post" >
<!-- <form action="gallery_upload.do" method="post" enctype=multipart/form-data> -->

<table class="gallery">
	<tr style="border-bottom:1px solid grey">
		 <th style="padding:10px 0; text-align : left; width: 70px; font-weight:700; color: grey">제목 :</th>
		 <td colspan="4"><h4>
		 	<input type="text" name="title" class="sub" value="${photo.title }" 
		 	style="font-size: 19px; width:700px; border:none; outline:none;">
		 	</h4></td>
	</tr>	
	<tr>
	<th style="padding:10px 0; text-align : left; width: 70px; font-weight:700; color: grey; width:80px;">이미지 :</th>
	<td colspan="4">
	<input type="file" name="img" style="font-size:16px;" value="${photo.img}">
	</td>
	</tr>
	<tr>
		<td colspan="5" style="text-align: left; height: 200px; padding-top: 20px;">
		<div style="white-space:pre-line;">
		<textarea name="content"
		style="width: 100%; height: 412px; outline:none; font-size: 16px; padding:10px;">
		<c:out value="${photo.content}"></c:out>
		</textarea>
		</div>
		</td>
	</tr>
	<tr>
		<td colspan="5">
		<div class="buttons">
		<input type="hidden" value="${mania.id}" name="id">
		<input type="hidden" value="${mania.nick}" name="nick">
			<input type='button' value='취소' onclick="location.href='gallery.do'" style="background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
			<input type='submit' value='수정'style="background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
		</div>
		</td>
	</tr>

</table>
	<div class="clear"></div>
</form>


</article>

<div class="bin"></div>

<jsp:include page="footer.jsp"/>


</body>
</html>