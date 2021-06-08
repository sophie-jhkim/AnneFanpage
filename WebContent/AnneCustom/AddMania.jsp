<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join us</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style type="text/css">
body{
font-family: 'Noto Sans KR', sans-serif;
}
.insert{
font-family: 'Noto Sans KR', sans-serif;
 width:450px; 
 height:500px;
 margin: 100px auto;
 font-size : 20px;

}
.insert textarea{
font-family: 'Noto Sans KR', sans-serif;
 font-size:18px;
}
.insert tr{ 
padding: 20px 0;
font-size:18px;
}
.insert th{
font-size:18px;
width: 27%;
}
.insert td{
padding: 0 5px;
}
.insert td span{
margin-bottom: 10px;
}
.insert input{
font-size:18px;
height: 25px;
}
</style>
<script type="text/javascript">

// function popupClose(form){
function popupClose(){
	var id = document.getElementById('id').value; 
	var pw = document.getElementById('pwd').value;
	var name = document.getElementById('name').value;
	var nick = document.getElementById('nick').value;
	var phone = document.getElementById('phone').value;
	var address = document.getElementById('address').value;
	var email = document.getElementById('email').value;
	var radios = document.querySelectorAll('input[type="radio"]:checked');

	if(id == ""){
		alert("아이디를 입력해주세요");
		document.form.id.focus();
		return false; //문제가 생겼으면 밑으로(아래 다른 진행) 내려가지 말아라
	}else if(pw == ""){
		alert("암호를 입력해주세요");
		document.form.pwd.focus();
		return false;
	}else if(name == ""){
		alert("이름을 입력해주세요");
		document.form.name.focus();
		return false;
	}else if(nick == ""){
		alert("닉네임을 입력해주세요");
		document.form.nick.focus();
		return false;
	}else if(phone == ""){
		alert("연락처 입력해주세요");
		document.form.tel.focus();
		return false;
	}else if(address == ""){
		alert("주소를 입력해주세요");
		document.form.address.focus();
		return false;
	}else if(email == ""){
		alert("이메일을 입력해주세요");
		document.form.email.focus();
		return false;
	}else if(radios.length <1){
		alert("마케팅 수신 동의 여부를 선택해주세요");
		return false;
	}
// 	else if(idCheck()==undefined){
// 		alert("ID check버튼으로 ID를 확인해주세요 ");
// 		return false;
// 	}
	alert("가입성공. 로그인 페이지로 이동합니다.");
	document.form.submit();
// 	form.target = opener.name;
	
// 	if(opener != null){
// 		opener.insert = null;
// 	opener.alert("가입성공. 로그인 페이지로 이동합니다.");
// 		self.close();
// //	 	window.open("about:blank", "_self").close();
// 	}
}
function idCheck(){
	var popupX = (window.screen.width / 2) - (200);
	var popupY= (window.screen.height / 2) - (200);
	var id = document.getElementById('id').value;
	if(id == ""){
		alert("아이디를 입력해주세요");
		document.form.id.focus();
	}else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
        alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
        document.form.id.focus();
    }else{
    	
		var child = window.open("../AnneCustom/checkId.do?id="+id, "check id", 'width=400, height=180, left='+popupX+', top='+popupY);
		if(document.child.ok.value == ""){
			alert("document.child.ok.value");
			return true; 
		}
	}
}

</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- <form action="join.do" method="post" name="form" target="index.do"> -->
<div style="position:relative">
<form action="join.do" method="post" name="form">
		<table class="insert">
			<tr>
				<th width="120px">ID</th>
				<td colspan="2">
					<input type="text" id=id name="id" size="20" maxlength = "12" required>
				</td>
				<td>
				<input type="button" onclick="idCheck()" id=idChk value="ID check"
				style="background : #214d0d; color : #ffffff;
				width : 100px; height : 35px; border:none; font-size:18px; outline:none;">
				</td>
			</tr>
			<tr>
				<th>Password</th>
				<td colspan="3">
					<input type="password" id=pwd name="pwd" size="20" maxlength = "12" required>
				</td>
			</tr>
			<tr>
				<th>Name</th>
				<td colspan="3">
					<input type="text" id=name name="name" size="20">
				</td>
			</tr>
			<tr>
				<th>Nick Name</th>
				<td colspan="3">
					<input type="text" id=nick name="nick" size="20">
				</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td colspan="3">
					<input type="text" id=phone name="phone" size="20" placeholder="Number only">
				</td>
			</tr>
			<tr>
				<th rowspan="2" style="vertical-align:top;">Address</th>
				<td colspan="2" rowspan="2">
				<textarea name="address" id=address style="width: 100%; height: 85%;" readonly></textarea>

				</td>
				<td  rowspan="2" style="vertical-align:top">
<!-- 					<input type="button" value="주소 검색" onclick="location.href='/webapp/jsEx/addressPopup.html'"> -->
					<input type="button" value="Find" onclick="post()"
					style="background : #214d0d; color : #ffffff; 
					width : 100px; height : 35px; border:none; font-size:18px; outline:none;">
				</td>
			
			</tr>
			<tr></tr>
			<tr>
				<th align="center">E-mail</th>
				<td colspan="3">
					<input type="email" id=email name="email" size="20" placeholder="abcde@gmail.com">
				</td>
			</tr>
			<tr>
				<th colspan="2" align="center">Marketing</th>
				<td colspan="2">
				<input type="radio" id=ad name ="ad" value="agree"> <span>Agree</span>
				<input type="radio" id=ad name ="ad" value="disgree"> <span>Disagree</span>
				</td>
			</tr>
			<tr>
				<td align="center" colspan ="2">
				<input type="reset" value="Reset"
				style="background : #214d0d; color : #ffffff; 
				width : 100px; height : 35px; border:none; font-size:18px; outline:none;">
				</td>
				<td align="center" colspan ="2">
<!-- 					<input type="submit" value="가입하기" onclick= "alert('환영합니다')"/> -->
					<input type="button" value="Submit" onclick="popupClose()"
					style="background : #d93240; color : #ffffff; 
					width : 100px; height : 35px; border:none; font-size:18px; outline:none;"/>
				</td>
			</tr>
		</table>
			<div class="img" style="width:600px; margin:auto;">
<!-- 			<img alt="anne" src="../AnneAdmin/AnnImage/visual/login.jpg" style="width:100%;"> -->
			</div>
	</form>
<!-- 		<input type="button" onclick="idCheck()" id=idChk value="ID check" -->
<!-- 				style="background : #214d0d; color : #ffffff; position:absolute; top:0; left:50%;margin-left:113px; -->
<!-- 				width : 100px; height : 35px; border:none; font-size:18px; outline:none;"> -->
	</div>

<div class="bin" style="height:120px"></div>
<jsp:include page="footer.jsp"/>
</body>
</html>