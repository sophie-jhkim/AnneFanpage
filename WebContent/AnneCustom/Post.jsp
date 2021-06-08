<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Address, java.util.*" %>
    <%@ page import="dto.ZipCode, java.util.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 찾기</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
<style>
body{
font-size:18px;
font-family: 'Noto Sans KR', sans-serif;
}
input{
font-size:18px;
}
</style>
<script type="text/javascript">
		function result(zipNum,sido,gugun,dong){
			opener.document.form.address.value=sido+" "+gugun+" "+dong+" "+"\n"+zipNum;
			self.close();
		}
		
		

</script>

</head>
<body>
<div id="popup" style="text-align:center">
<h1>Address Search</h1>
<form method="post" name=form action="../AnneCustom/zipcode.do">
동 이름 : <input name="dong" type="text"> 
	<input type="submit" value="search" class="submit"> 

</form>
<table id="zipcode"  style="width: 450px; margin:auto; text-align:center; margin-top:20px;">
<tr>
	<th >Zip Code</th>
	<th style="">Address</th>
</tr>
<%-- <% ZipCode zipcode = (ZipCode)request.getAttribute("zipcode");%> --%>
<%
	ArrayList<ZipCode> list = (ArrayList<ZipCode>)request.getAttribute("zipcode"); 
	if(list != null){
		for(ZipCode data : list){
%>
		<tr>
			<td> <%=data.getZipcode() %></td>
			<td><a href="#" onclick="result('<%=data.getZipcode() %>','<%=data.getSido() %>','<%=data.getGugun() %>','<%=data.getDong() %>')">
			<%=data.getSido()%><%=data.getGugun()%><%=data.getDong() %></a></td>
		</tr>
<% 
		}
	}
%>
</table>
</div>


</body>
</html>