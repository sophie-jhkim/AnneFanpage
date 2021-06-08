<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

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
<script type="text/javascript">
function findPw(){
	var url ="FindPw.jsp";
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=250, top=300, left=300" );
	
}
function findId(){
	var url ="FindId.jsp";
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=250, top=300, left=300" );
	
}
</script>
<title>login</title>
</head>
<body>
<jsp:include page = "header.jsp"/>

<form action="login.do" method ="post">
	<div class="box">
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
<!-- 				<b><a href="join.do" onclick="window.open(this.href,'회원가입','width=620, height=740','_blank');return false;" -->
<!-- 				style="font-size:19px; color:red; ">Join now</a></b></td> -->
				<td></td>
			</tr>
		
		</table>
		<input type="submit" value="Login" class="submit"/>
	</div>	
<!-- 		<div class="img" style="width:700px; margin:auto; "> -->
<!-- 			<img alt="anne" src="../AnneAdmin/AnnImage/visual/login.jpg" style="width:100%;"> -->
<!-- 		</div> -->
</form>
<div class="bin"></div>

<jsp:include page = "footer.jsp"/>

</body>
</html>