<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
   <%@ page import="dto.Mania"%>
   <%@ page import="dto.Goods" %>
   <%@ page import="dto.Board" %>
   <%@ page import="dto.Notice" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../CSS/slick.css"> 
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<script src="../JS/jquery-3.1.1.min.js"></script>
<script src="../JS/slick.min.js"></script>
   <script type="text/javascript">
   $(function() {
       $('.swiper-wrapper').slick({
           autoplay: true,
           dots: true,
           autoplaySpeed: 2500,
           fade: false,
           pauseOnHover: false,
       });
       
       $('.btn_top').click(function(){
           $('html, body').animate({scrollTop:'0'}, 500)
       });
   });

   </script>
<style type="text/css">
body{
font-family: 'Noto Sans KR', sans-serif;
}

.swiper-container{
/* 	position: relative; */
}
.swiper-wrapper{
	width:100%;
/* 	position: absolute; */
}
.swiper-wrapper img{
 width:100%;
}
.swiper-container .slick-prev {
/*     background: url(AnnImage/home/main_visual_prev.png) no-repeat left top; */
    position: absolute;
    left: 30px;
    top: 50%;
    width: 45px;
    height: 45px;
/*     width: 23px; */
/*     height: 45px; */
    z-index: 10;
    text-indent: -9999px;
    outline: none;
    background-color: rgba( 255, 255, 255, 0 );
/*     background-size: 23px; */
    cursor: pointer;
    border-left: 3px solid white;
    border-bottom: 3px solid white;
    border-top: none;
    border-right: none;
    transform : rotate( 45deg );
/*     border:none; */
}
.swiper-container .slick-next {
    position: absolute;
    right: 30px;
    top: 50%;
    width: 45px;
    height: 45px;
    z-index: 10;
    text-indent: 100%;
    font-size:0;
    outline: none;
    cursor: pointer;
    background-color: rgba( 255, 255, 255, 0 );
    cursor: pointer;
    border-left: 3px solid white;
    border-bottom: 3px solid white;
    border-top: none;
    border-right: none;
    transform : rotate( 225deg );
}

.swiper-container .slick-dots {
    position: absolute;
    left: 50%;
    top: 92%;
    margin-left:-50px;
}

.swiper-container .slick-dots li {
    display: inline-block;

}

.swiper-container .slick-dots li button {
    background: rgba(238, 238, 238, 0.70);
    width: 10px;
    height: 12px;
    border-radius: 7px;
    text-indent: -9999px;
    margin: 0 5px;
    cursor: pointer;
    outline: none;
    border:none;
}
.swiper-container .slick-dots .slick-active button {
    width: 20px;
    height: 12px;
    border-radius: 7px;
    background: #fff;
    border:none;
}
.section1{
	width: 1000px;
	height: 330px;
	margin:20px auto;
}
.board{
	width: 420px;
	height: 320px;
	float: left;
}
.section1 .comm td{
}
.section1 .comm td a{
	width: 380px;
	text-overflow:ellipsis;
	white-space: nowrap;
	overflow:hidden;
	word-break:normal;
	display : inline-block;
}
.media{
	 width: 570px;
	 float: right;
}
.section2{
	width: 1000px;
	height: 330px;
	margin:auto;
	margin-top:50px;
	margin-bottom:100px;
}
.section2 .list{
width : 1000px;
margin : auto;
overflow :hidden;
font-family: 'Noto Sans KR', sans-serif;
}
.section2 .list span{
text-align : center;
margin : auto;
color :  #14370b;

}
.section2 .list p{
padding: 10px;
}
.section2 .list a:hover{
opacity: 0.6;
/* background-color: rgba( 255, 255, 255, 0.5 ); */
}
.section2 td{
padding:30px; 
text-align:center;
}
.section2 h3{
font-family: 'Noto Sans KR', sans-serif;
margin: auto;
text-align: center;
font-size: 25px;
font-weight: 700;
padding: 10px;
width: 200px;
border-bottom :  3px solid #214d0d;
}
.list image{
width : 150px;
margin:auto;
}
.board p{
font-family: 'Noto Sans KR', sans-serif;
background : #214d0d; 
color : #ffffff; 
width: 100px;
height : 35px; 
border:none; 
font-size:19px; 
font-weight:500;
outline:none;
text-align:center;
vertical-align:middle;
border-radius: 0 25px 0 0;
/* border-top-right-radius: 30px 30px; */
line-height: 38px;
}
.comm{
 width: 100%;
 margin:auto;
 border: 2px solid #214d0d; 
 font-family: 'Noto Sans KR', sans-serif;
 font-size : 18px;
 text-indent:15px
}
.comm td{
padding : 10px 0;
border-bottom: 1px solid grey;
}
</style>
<title>Home</title>
</head>
<body>
<div style="position:absolute; z-index:99; width:100%">
<jsp:include page = "header.jsp"/>
</div>
<div class="swiper-container" style="">
    <div class="swiper-wrapper">			
        <div class="m5"><img alt="anne4" src="../AnneAdmin/AnnImage/visual/visual7.jpg"></div>
        <div class="m1"><img alt="anne1" src="../AnneAdmin/AnnImage/visual/visual1.jpg"></div>
        <div class="m2"><img alt="anne2" src="../AnneAdmin/AnnImage/visual/visual2.jpg"></div>
        <div class="m3"><img alt="anne3" src="../AnneAdmin/AnnImage/visual/visual3.jpg"></div>
        <div class="m4"><img alt="anne4" src="../AnneAdmin/AnnImage/visual/visual6.jpg"></div>
    </div>
      <div class="swiper-pagination"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-button-next"></div>
</div>

<section class="section1">
	<div class="board">
	<p>Board</p>
	<table class="comm">
		<c:forEach var="bo" items="${board}" begin="0" end="6">
		<tr>
		<td class="title2" style="text-align:left;">
		<a href="board_detail.do?bseq=${bo.bseq}" style="color: black">${bo.subject}</a></td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<div class="media">
	<iframe width="570" height="320" src="https://www.youtube.com/embed/ic8wc9X_qHM" 
	frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
	allowfullscreen></iframe>
	</div>

</section>
<section class="section2">
	 <h3> Best Items</h3>
	 
	 	<table style="margin: auto;" class="list">
	<tr>
<c:forEach var="goods" items="${best}" begin="0" end="3">
			<td><a href="../AnneAdmin/ShopDetail.do?pseq=${goods.pseq}" style="text-decoration:none; color:black;">
			<image src="../AnneAdmin/AnnImage/goods/${goods.img}" width="180px"/><br>
			<input type="hidden" value="${goods.pseq}">
			<p> ${goods.name}</p>
			<span>${goods.price2} 원</span>
			</a>
			</td>
		
</c:forEach>
 	</tr>
 	</table>
</section>


<jsp:include page = "footer.jsp"/>

</body>
</html>