<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Address, java.util.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 찾기</title>
<script type="text/javascript">
		function result(zipNum,sido,gugun,dong){
			opener.document.form.address.value=sido+" "+gugun+" "+dong+" "+zipNum;
			self.close();
		}
		
		

</script>

</head>
<body>
<div id="popup">
<center><h1> 우편번호 검색</h1></center>
<form method="post" name=form action="/webapp/UserInfoPostServlet">
동 이름 : <input name="dong" type="text"> 
	<input type="submit" value="찾기" class="submit"> 

</form>
<table id="zipcode">
<tr>
	<th>우편번호</th>
	<th>주소</th>
</tr>
	</table>
	<table>
<%
	ArrayList<Address> list = (ArrayList<Address>)request.getAttribute("addressList"); //아 미친 이거 안넣어서 안뜬거였음
	if(list != null){
		for(Address data : list){
%>
		<tr>
			<td> <%=data.getZipCode() %></td>
			<td><a href="#" onclick="result('<%=data.getZipCode() %>','<%=data.getSido() %>','<%=data.getGugun() %>','<%=data.getDong() %>')">
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