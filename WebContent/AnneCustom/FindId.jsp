<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="dto.Mania" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>Find ID</title>
<style type="text/css">
.submit{
font-size: 16px;
height : 30px; 
border:none; 
outline:none;
padding: 0 10px;
background:#214d0d; 
color:#fff;
font-family: 'Noto Sans KR', sans-serif;
}
table{
font-family: 'Noto Sans KR', sans-serif;
text-align:center;
font-size:18px;
margin:10px auto;
}
table td{
padding:5px
}
input{
border:none;
outline:none;
}
h3{
padding:5px;
text-align:center;
margin:auto;
}
div{
padding:5px;
font-family: 'Noto Sans KR', sans-serif;
font-size: 16px;
text-align:center;
margin:auto;
}
div span{
font-family: 'Noto Sans KR', sans-serif;
font-size: 18px;
font-weight:500;
text-decoration:underline;
padding: 5px 2px;
}
.button{
font-size: 16px;
height : 30px; 
border:none; 
outline:none;
padding: 0 10px;
background:#214d0d; 
color:#fff;
font-family: 'Noto Sans KR', sans-serif;
text-align:center;
margin: 10px auto;
}
</style>
<script type="text/javascript">
function findId(){
	var url ="FindId.jsp";
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=250, top=300, left=300" );
	
}
</script>
</head>
<body>
<form method="post" name="form" action="../AnneCustom/findId.do">
<h3>아이디 찾기</h3>

<% Mania mania = (Mania)request.getAttribute("mania");
if(request.getParameter("phone")== null){
	%>

<table>
<tr>
<th>Phone :</th>
<td><input type="text" name="phone" style="border-bottom:1px solid grey;"> 
</tr>
<tr>
<th>E-mail :</th>
<td><input type="text" name="email" style="border-bottom:1px solid grey"> 
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="찾기" class="submit">
</td>
</tr>
</table>
<%
}else if(mania != null){
%>
<div>고객님의 아이디는 <span><%= mania.getId()%></span> 입니다.<br>
<input type="button" value="닫기" onclick="window.close()" class="button"/></div>

<%}else{ %>
<div> 해당하는 고객 정보가 없습니다. <br>
<input type="button" value="재시도" onclick="findId()" class="button"/>
<input type="button" value="닫기" onclick="window.close()"class="button" />
</div>
<%} %>

</form>

</body>
</html>