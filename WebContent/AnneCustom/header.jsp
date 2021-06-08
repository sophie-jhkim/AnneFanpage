<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Mania"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<meta charset="UTF-8">
<%
	Mania mania = (Mania) session.getAttribute("mania");
%>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css"> 
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style type="text/css">
#logo{
	width: 200px;
	height: 230px;
	border-radius: 0 0 10px 10px;
	background-color:#1d2001;
	position:absolute;
	margin-top:-35px;
	margin-left:100px;
}
#logo p{
 font-size: 25px;
 margin-top:20px;
}
#util{
height: 35px; 
margin-top:0; 
background-color: rgba( 0, 0, 0, 0.5 );
color: #ffffff; 
position:relative; 
width:100%;
font-family: 'Noto Sans KR', sans-serif;
}
#util ul{
 line-height:35px;
}
#util ul li{
	float:left;
	padding : 0 10px;
}
#menu{
	background-color: #14370b; 
	color: #ffffff; 
	height: 60px;
	font-family: 'Noto Sans KR', sans-serif;
	
}
#menu ul{
	 line-height:60px;
	 margin-left: 350px;
	 width: 600px
}
#menu ul li{
	float:left;
	padding : 0 20px;
	font-size: 19px;
}
a{
text-decoration:none;
color: #ffffff; 
}
</style>
<script type="text/javascript">

// 	function addMania(){
// // 		window.name="index.do";
// // 		var url = "AddMania.jsp";
//  		window.name="index.do";
//  		var url = "join.do";
// 		window.open(url,"insert", "width=620, height=740, top=100, left=300");
// 	}
	 function post(){
			var url = "Post.jsp";
			window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=600, height=300, top=300, left=300");
		}
	 
	 function search(){
		 var keyword= document.getElementById("name").value;
		 document.formmsearch.action ="../AnneCustom/search.do?name="+keyword;
		 document.formmsearch.submit();
	 }
</script>

<title>header</title></head>

<form>
<div id="util">
	<ul style="float:right; margin-right:5%;">
		<c:choose>
			<c:when test="${sessionScope.mania !=null}">
			<li>
				<c:set var="mania" value="${sessionScope.mania}" />
<%-- 			<%= mania.getNick() %> --%>
				${mania.nick}님 <a href="../AnneCustom/logout.do" style="">Logout</a>
				<c:if test="${mania.id=='admin'}" var="admin">
				<a href="../AnneAdmin/Manias.do" style="color: white; padding:2px 10px; 
				background-color:#d93240; border-radius: 5px; text-decoration: none;">관리자 페이지</a>
				</c:if>
			</li>
			<li><a href="../AnneCustom/scrap.do" style="color:red; font-size:16px">♥</a></li>
			<li><a href="../AnneCustom/Mania_info.do">Mypage</a></li>
			<li><a href="../AnneCustom/cart.do">Cart</a></li>
			</c:when> 
		<c:otherwise>
			<li><a href="../AnneCustom/login.do" >Login</a></li>
<!-- 			<li><a href="join.do" onclick="window.open(this.href,'join','width=620, height=740','_blank');return false;">Join</a></li> -->
			<li><a href="../AnneCustom/join.do" >Join</a></li>
<!-- 			<li><a href="javascript:addMania();" >Join</a></li> -->
			<li><a href="../AnneCustom/login.do">Mypage</a></li>
			<li><a href="../AnneCustom/login.do">Cart</a></li>
		</c:otherwise>
		</c:choose>
	</ul>
</div>
</form>
<div id="menu" style="position: relative;">
	<div id="logo" style="text-align:center; z-index:99"><a href="../AnneCustom/index.do">
		<img alt="logo" src="../AnneAdmin/AnnImage/home/logo.png" style="width:170px; margin-top:50px;">
		<p>Fan Page</p>
	</a></div>
	<ul style="float:left;" >
		<li><a href="../AnneAdmin/Anne.do">About</a></li>
		<li><a href="../AnneAdmin/Notice.do">Notice</a></li>
		<li><a href="../AnneCustom/gallery.do">Gallery</a></li>
		<li><a href="../AnneCustom/board.do">Community</a></li>
		<li><a href="../AnneAdmin/Shop.do">Shop</a></li>
	</ul>
	<div style="position: relative; float:right; width:200px; margin-right:100px">
	<form action="../AnneCustom/search.do" method="post" name="formmsearch">
	<input type="text" name="name" id="name"
	style="width:200px; height:27px; border-radius:20px; border:1px solid #b5c453; outline:none;
	margin-top: 15px; float:right; font-size: 16px; text-indent:7px;">
<!-- 	<input type="submit" value=""  -->
<!-- 	style="background:url(../AnneAdmin/AnnImage/home/search.png);  -->
<!-- /* 	background-size:27px; position:absolute; margin-top:16px; margin-left:83% ; border:none; */ -->
<!-- 	background-repeat:no-repeat; width:27px; height:30px"> -->
	<img alt="search" src="../AnneAdmin/AnnImage/home/search.png" style="
	position:absolute; width:27px; margin-left:83% ;margin-top:16px;" onclick="search()">
	</form>
	</div>
	
</div>