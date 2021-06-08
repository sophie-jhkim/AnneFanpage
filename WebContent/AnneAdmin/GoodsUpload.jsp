<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>상품 업로드</title>
<style type="text/css">
article{
width:900px; 
margin:auto; 
}
.goods{
width:900px; 
margin:auto; 
font-size: 20px; 
}
.goods td{
padding : 5px 0;
}
.title h3{
border-left : 5px solid #214d0d;
font-size:30px;
font-weight: bold;
margin: 50px 0 50px 20px;
padding: 3px 20px;
}
.goods .buttons{
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
<jsp:include page="../AnneCustom/header.jsp"/>

<article style="width: 900px; margin: auto">
<div class="title">
<h3>상품 업로드</h3>
</div>

<!-- <form action="goods_insert.do" method="post" enctype=multipart/form-data> -->
<form action="goods_insert.do" method="post">

<table class="goods">
	<tr style="border-bottom:1px solid grey">
		 <th style="padding:10px 0; text-align : center; font-weight:700; color: grey">상품 명 :</th>
		 <td colspan="4"><h4>
		 	<input type="text" name="name" class="sub" style="font-size: 19px; width:700px; border:none; outline:none;">
		 	</h4></td>
	</tr>
	<tr>
		<th style="text-align : left; width: 200px; font-weight:700; color: grey; " >
			분류 :
			</th>
			<td style=" text-align : left;">
		 <select name="kind" style="font-size: 16px;">
		<option value="1">도서</option>
		<option value="2">문구류</option>
		<option value="3">의류</option>
		<option value="4">생활잡화</option>
		<option value="5">폰 악세사리</option>
		 </select>
		 </td>
	</tr>
	<tr>
		<th style="text-align : left; font-weight:700; color: grey; "> 
			베스트 상품 여부 :
			</th>
		<td>
		 <select name="bestyn" style="font-size: 16px;">
		<option value="y">베스트 상품</option>
		<option value="n">일반 상품</option>
		 </select>
		 </td>
		 
	</tr>	
	<tr>
	 <td colspan="4" style="text-align : left; font-weight:700; color: grey">
		 원가 : <input type="text" name="price1" style="font-size: 16px; width: 150px; margin-right:30px">
		 판매가 : <input type="text" name="price2" style="font-size: 16px; width: 150px; margin-right:30px">
		 마진 : <input type="text" name="price3" style="font-size: 16px; width: 150px;">
	</td>
	</tr>
	<tr>
	<th style="padding:10px 0; text-align : left; width: 70px; font-weight:700; color: grey; width:80px;">이미지 :</th>
	<td colspan="4">
	<input type="file" name="img" style="font-size:16px;">
	</td>
	</tr>
	<tr>
		<td colspan="5" style="text-align: left; height: 200px; padding-top: 20px;">
		<textarea name="content" id="content" 
		style="width: 100%; height: 412px; outline:none; font-size: 16px; padding:10px;">
		</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="5">
		<div class="buttons">
		<input type="hidden" value="${mania.id}" name="id">
		<input type="hidden" value="${mania.nick}" name="nick">
			<input type='button' value='취소' onclick="location.href='AdminGoods.do?page=1'" style="background : #214d0d; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
			<input type='submit' value='등록'style="background : #d93240; color : #ffffff; 
				width : 60px; height : 30px; border:none; font-size:16px; outline:none;">
		</div>
		</td>
	</tr>

</table>
	<div class="clear"></div>
</form>


</article>

<div class="bin"></div>

<jsp:include page="../AnneCustom/footer.jsp"/>


</body>
</html>