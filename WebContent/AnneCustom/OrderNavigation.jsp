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
<meta charset="UTF-8">

<style>

#nav li a{
color: #214d0d;
padding: 7px 10px;
display:block;
font-family: 'Noto Sans KR', sans-serif;
}
#nav li a:hover{
	color: white;
	background-color : #214d0d;
}

</style>
<title>Order ShortCut</title>
</head>
<body>
	<nav style="position: absolute; left:1%; top:40%" id="nav">
		<ul style="list-style:none; font-size:18px">
			<li style="">
				<a href="cart.do" style="text-decoration:none;">Cart</a>
			</li>
			<li style="">
				<a href="order.do" style="text-decoration:none;">주문정보</a>
			</li>
			<li style="">
				<a href="order_history.do" style="text-decoration:none;">주문내역</a>
			</li>
		</ul>
	</nav>

</body>
</html>