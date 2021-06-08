<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="dto.Mania" %>
 <%@ page import="dao.ManiaDao" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<% Mania mania = (Mania)request.getAttribute("mania");%>
<html>
<head>
<style type="text/css">
.bin{
height : 600px;
}
.box{
	width: 460px;
	margin:auto;
	height: 300px;
	position: relative;
}
.loginform{
	margin:auto;
	margin-top:100px;
	font-size : 23px;
	height: 120px;
	float:left;
}

.loginform th{
 color:#1d2210;
 font-size : 23px;
 align : center

}
.loginform td{
 color:#1d2210;
 font-size : 23px;
  padding: 0 10px;
 align : center
}
a{
text-decoration: none;
}
input{
font-size: 20px;
}
.submit{

background : #214d0d; 
color : #ffffff; 
width : 80px; 
height : 80px;
border:none; 
font-size:18px; 
outline:none;
position: absolute;
top:95px;
right: 10px
}

</style>
<meta charset="UTF-8">
<title>Login Fail</title>
</head>
<body>
<jsp:include page = "header.jsp"/>

<%
// 	ManiaDao maniaDao = new ManiaDao();
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
// 	Mania result = maniaDao.exist(id, pwd);
	if(mania != null){
%>
<h2>비밀번호를 확인해주세요</h2>
<% 
// 	}else if(mania.getPwd().equals(pwd)){
	}else if(pwd == null){
%>
<h2>아이디를 확인해주세요. </h2>
<%
	}else{
%>

<form action="login.do" method ="post">
	<div class="box">
	<h4 style="color:red; position:absolute; top:60px; left: 80px;"> 존재하지 않는 정보입니다. 다시 확인해주세요 </h4>
		<table class="loginform">
		
			<tr>
				<th>ID</th>
				<td colspan="2">
					<input type="text" name="id" size="20" required >
				 </td>
			</tr>
			<tr>
				<th>Password</th>
				<td colspan="2" >
					<input type="password" name="pwd" size="20" required>
				 </td>
				 <td></td>
			</tr>
			<tr>
				<td colspan="2"><a href="#" onclick="findId()" style="font-size:18px; color:black">id ·</a>
				<a href="#" onclick="findPw()" style="font-size:18px; color:black"> password finding</a></td>
				<td colspan="3" style="text-align:right;">
				<b><a href="join.do" style="font-size:19px; color:red; ">Join now</a></b></td>
				<td></td>
			</tr>
		
		</table>
		<input type="submit" value="Login" class="submit"/>
	</div>	
</form>
<div class="bin"></div>

<%
}
%>

<jsp:include page = "footer.jsp"/>

</body>
</html>