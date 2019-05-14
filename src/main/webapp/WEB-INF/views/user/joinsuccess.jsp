<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>MySite</h1>
			<ul>
				<li><a href="">로그인</a>
				<li>
				<li><a href="">회원가입</a>
				<li>
				<li><a href="">회원정보수정</a>
				<li>
				<li><a href="">로그아웃</a>
				<li>
				<li>님 안녕하세요 ^^;</li>
			</ul>
		</div>
		<div id="content">
			<div id="user">
				<p class="jr-success">
					회원가입을 축하합니다. <br>
					<br> <a href="/user?a=loginform">로그인하기</a>
				</p>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<!-- 파일을 생성해두고 불러와서 적용 -->
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>