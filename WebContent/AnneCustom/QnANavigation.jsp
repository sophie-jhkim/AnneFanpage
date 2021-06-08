<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Mania" %>
<%@ page import="dto.QnA" %>
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
<title>MyPage ShortCut</title>
</head>
<body>
	<nav style="position: absolute; left:1%; top:40%" id="nav">
		<ul style="list-style:none; font-size:18px">
			<li style="">
				<a href="../AnneCustom/Mania_info.do" style="text-decoration:none;">내 정보</a>
			</li>
			<li style="">
				<a href="../AnneCustom/QnA.do" style="text-decoration:none;">고객센터</a>
			</li>
		</ul>
	</nav>

</body>
</html>