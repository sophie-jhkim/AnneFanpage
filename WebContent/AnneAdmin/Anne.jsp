<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Anne</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=PT+Serif:ital@1&family=Amatic+SC:wght@400;700&family=DM+Serif+Text:ital@0;1&family=Neucha&family=Prata&display=swap" rel="stylesheet">
<style type="text/css">
body{
width: 100%;
/* background: #0b2207; 214d0d*/
/* background: linear-gradient(30deg, #0b2207, #275b0f); */
background: linear-gradient(to top, #112318, #1E3A29);
font-family: 'Noto Sans KR', sans-serif;
}
.cnt{
width: 900px;
margin: auto;
}
.drama{
width: 900px;
margin: auto;
border-top: 2px solid white;
color: white;
}
.drama h2{
font-family: 'Prata', serif;
font-size: 35px;
padding-bottom: 15px
}
.drama td{
vertical-align: middle;
padding: 20px;
line-height: 21px;
font-family: 'Noto Sans KR', sans-serif;
}
.char{
width: 900px;
margin: auto;
margin-bottom: 50px;
}
.char td{
vertical-align: middle;
padding: 15px;
font-family: 'Noto Sans KR', sans-serif;
color: white;
line-height: 21px;
}
.char td p{
font-size: 20px;
background-color:#d93240;
padding : 7px;
text-indent: 10px;
}
.char td p span{
font-size: 18px;
font-family: 'PT Serif', serif;
}
.quote{
width: 800px;
margin: auto;
position: relative;
padding: 50px 0 0 0;
}
.quote h2{
font-family: 'Amatic SC', cursive;
/* font-family: 'Neucha', cursive; */
font-size : 45px;
font-weight: 700;
color: white;
padding: 100px 0 10px 0;
}
.netflix{
 position:relative
}
.netflix a{
font-size: 14px;
font-weight: bold;
}
.netflix span{
position:absolute;
left:10px;
bottom:-5px;
}
.char h3{
font-family: 'Noto Sans KR', sans-serif;
font-size : 35px;
font-weight: 500;
color: white;
padding: 50px 0 15px 0;
text-align:center;
width:250px;
margin:auto;
border-bottom: 2px solid white;
}
</style>
</head>
<body>
<jsp:include page = "../AnneCustom/header.jsp"/>
<article>
<div class="quote">
<h2>Isn't it amazing how everyday can be an adventure </h2>
<img alt="anne" src="AnnImage/visual/annepng.png" 
style="width: 100px; position: absolute; right:10px; bottom:-2px">
</div>
<div class="cnt">
<table class="drama">
<tr>
<td><img alt="anne" src="AnnImage/visual/Shirbert5.JPG" style="width: 400px"></td> 
<td><h2>Anne with an e</h2>
	<p>마음에 불꽃을 품은 여자아이 앤.<br>
	나이 든 오누이의 초록지붕집에 발을 들이게 된다.<br> 
	커스버트 남매와 낯선 고아 소녀가 가족이 되고 성장하는 과정을 그려낸 시리즈.</p>
	<br>
	<p>
	루시 모드 몽고메리의 동명 소설을 원작으로 한 캐나다의 TV 드라마로
	《브레이킹 배드》의 제작과 각본으로 유명한 모이라 월리베켓이 제작하였고, 각 에피소드는 니키 카로, 어맨다 태핑 등이 연출했다. 
	캐나다 CBC 텔레비전 채널에서 2017년부터 2019년까지 방영되었으며, 넷플릭스에서도 서비스되었다.
	</p>
	<div style=" padding-top: 30px" class="netflix">
	<a href="https://www.netflix.com/kr/title/80136311" target="_blank">
	<img alt="netflix" src="AnnImage/visual/netflix.png" style="width: 150px"><br><span>빨간머리앤 바로가기</span></a>
	</div>
</td>
</tr>
</table>


<table class="char">
<tr><td colspan="2" style="padding-bottom:30px;"> <h3>Characters</h3> </td>
</tr>
<tr>
<td>
<img alt="anne" src="AnnImage/visual/anne11.jpg" style="width: 300px">
</td> 
<td> 
<p>앤 셜리 커스버트<span> Anne Shirley Cuthbert</span></p><br>
빨간 머리와 주근깨가진 얼굴, 파란 눈은 빨간 머리 앤의 특징이다.<br>
개성있는 외모와 또래 여자애들과는 다른 깡을 가지고 있는 활기찬 아이.<br> 
보기만해도 미소가 절로 지어지는 착한 앤에겐 과거 보육원에서 상처받으며 자란 기억이 자리잡고 있다.<br>
앤 셜리였던 원작과 달리 앤 셜리 커스버트라는 이름을 쓰는 것은  '할머니의 앤이 아닌 현시대를 살아가는 우리의 앤이다'라는 캐치프레이즈를 보여준다.
</td>
</tr>
<tr>
<td>
<img alt="anne" src="AnnImage/visual/gilbert5.jpg" style="width: 300px">
</td>
<td>
<p>길버트 브라이스<span> Gilbert Blythe</span></p><br>
앤과 동급생이지만, 아버지를 따라 서부 일대에서 거주한데다 아버지의 몸이 좋지 않아 학교를 몇 년 쉬었다가 다시 에이번리로 돌아온 탓에 나이는 앤보다 3살 많다. <br>
미인들만 이름이 올라가는 게시판인 주목에 늘 이름이 적혀 있을 만큼 잘생긴 갈색 곱슬머리 소년으로 길버트가 돌아올 시점에서 모든 여자아이들이 그를 볼 생각에 두근대기도 한다
</td>
</tr>
<tr>
<td>
<img alt="anne" src="AnnImage/visual/Diana.jpg" style="width: 300px">

</td>
<td>
<p>다이애나<span> Diana Barry</span></p><br>
앤 셜리의 베프로 앤이 그린게이블즈에 와서 처음 사귄 친구. 검은 머리에 검은 눈을 가진 귀여운 미소녀로 앤과 평생 우정을 나눈 친우다.<br> 
그린 게이블즈와 가까운 곳에 살기 때문에 촛불로 신호를 만들어서 둘만의 연락을 취하기도 한다.<br>
윤기나는 흑발에 반짝이는 검은 눈, 희고 고운 피부와 장밋빛 뺨을 가진 데다 마을에서 손꼽히는 부잣집 딸이여서 레이스가 잔뜩 달린 퍼프 소매가 있는 공주님 같은 옷을 입고 다니기 때문에 때문에 앤이 부러워하기도 했으며 학교 내 미소년과 미소녀들을 뽑는 게시판에 늘 이름이 올라갔다고 한다. 
</td>
</tr>
<tr>
<td>
<img alt="anne" src="AnnImage/visual/Marilla2.jpg" style="width: 300px">

</td>
<td>
<p>마릴라 커스버트<span> Marilla Cuthbert</span></p><br>
커스버트 집안의 사람으로 매튜 커스버트의 여동생. <br>
매튜와 마릴라 둘 다 결혼하지 않고 남매끼리 같이 살다가, 오빠가 나이가 들어 혼자 농사짓기 힘들어지자 농삿일을 도와 줄 남자아이를 입양하려 했다.<br>
그래서 잘못 온 앤을 돌려보내려고 했으나 매튜가 앤을 집에 두고 싶어했고, 앤이 갓난아기일 때 고아가 되어 학교도 제대로 못 다니고 불행한 삶을 살았다는 것을 알게 되자 마음이 흔들렸다. 거기다 앤을 하녀로 데리고 갈 블루엣 부인의 성격이 나쁜 것을 보자 결국 앤의 입양을 결심하고 그린 게이블즈로 도로 데리고 온다. <br>
처음엔 앤의 수다와 공상에 적응을 못하지만 어느새 앤이 없을 때 쓸쓸해하는 자신을 발견하게 된다.

</td>
</tr>
<tr>
<td>
<img alt="anne" src="AnnImage/visual/Matthew_Cuthbert2.jpg" style="width: 300px">

</td>
<td>
<p>매튜 커스버트<span> Matthew Cuthbert</span></p><br>
마릴라 커스버트의 오빠로 수줍고 소심한 아저씨. 말수가 별로 없고 여자와 이야기하게 되면 말을 더듬게 되어, 여동생 마릴라를 제외한 여자와 함께 있는 것을 매우 두려워한다.<br>
매슈는 앤에게 처음 만남부터 영혼이 통하는 사람으로 앤에게 아낌없는 사랑을 주는 사람 중 하나이다.<br> 
소설 속 매슈는 은행이 부도가 나면서 심장마비로 생을 마감하지만 드라마 속에서 매슈는 배사고로 인해 작물 수출에 있어 엄청난 경제적 손실을 얻지만 생을 마감하진 않는다. 
</td>
</tr>
<tr>
<td>
<img alt="anne" src="AnnImage/visual/RachelLynde2.jpg" style="width: 300px">

</td>
<td>
<p>레이첼 린드<span> Rachel Lynde</span></p><br>
마릴라의 친구. 통칭 린드 부인. <br>
소심하고 존재감 없는 남편 토마스 린드와 달리 에이번리에서는 오지랖과 빠른소식통으로 이름난 부인으로 작중 등장인물들의 대화에 항상 이름이 언급될 정도 미친 존재감을 나타내고있다.<br>
처음 앤과 만났을 때 빨강머리와 주근깨에 대해 지적했다가 앤의 거친 항의를 받는다. 그렇지만 앤은 매튜의 설득으로 그 다음날 사과를 했고,린드 부인은 금세 마음이 풀어져 그 후로 평생 앤과 교류한다. 
</td>
</tr>

</table>
</div>


</article>


<jsp:include page = "../AnneCustom/footer.jsp"/>
</body>
</html>