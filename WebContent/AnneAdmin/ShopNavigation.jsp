<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=PT+Serif:ital@1&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<style type="text/css">
#nav{
position: absolute;
left:1%;
top: 40%;
}
#nav ul{
font-size: 18px;
}


#nav li a{
color: #214d0d;
padding: 7px 10px;
display:block;
font-family: 'Noto Sans KR', sans-serif;
}
#body #nav ul li a:hover{ 
 background-color: #d93240;
 color: white; 
} 

</style>
<title>Shop Navigation</title>
</head>
<body id="body">

<nav id="nav">
	<ul>
		<li><a href="Category.do?kind=1">Books</a></li>
		<li><a href="Category.do?kind=2">Stationary</a></li>
		<li><a href="Category.do?kind=3">Clothes</a></li>
		<li><a href="Category.do?kind=5">Phone Acc</a></li>
		<li><a href="Category.do?kind=4">others</a></li>
	</ul>
 
</nav>
</body>
</html>