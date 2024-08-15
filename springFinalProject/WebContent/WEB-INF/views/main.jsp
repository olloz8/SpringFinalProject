<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssMain.css">
<meta charset="UTF-8">
<title>인하공업전문대학 컴퓨터정보공학과</title>
</head>
<body>
	<!-- spring Board Project의 main Page 입니다. -->
	<h2 class="btn-dark">인하공업전문대학 컴퓨터정보공학과 미니 페이지</h2>
	<h6>
		<c:if test="${not empty sessionScope.currentUser}">
			어서오세요, ${sessionScope.currentUser.userId}님!
		</c:if>
	</h6>

	<!-- 페이지에서 제공하는 각 카테고리 게시판 연결버튼은 Script 문에 의하여 BoardCategory가 전달됩니다.
         @onclick="submitForm('')" 각 Board의 Category에 해당하는 value값을 전달하여 board url로 post 요청을 전송합니다.
    -->
	<form id="categoryForm" action="board" method="post">
		<input type="hidden" id="boardCategory" name="boardCategory" value="">
		<input type="hidden" id="buttonValue" name="buttonValue" value="">

		<div class="dropdown">
			<button type="button" class="btn btn-dark btn-pad">
				<span class="dropbtn_icon"></span> 학과안내
			</button>
			<div class="dropdown-content">
				<button type="button" data-value="학과소개"
					onclick="submitForm('deptinfo', this)">학과소개</button>
				<button type="button" data-value="학과연혁"
					onclick="submitForm('depthistory', this)">학과연혁</button>
			</div>
		</div>

		<div class="dropdown">
			<button type="button" class="btn btn-dark btn-pad">
				<span class="dropbtn_icon"></span> 교과과정
			</button>
			<div class="dropdown-content">
				<button type="button" data-value="1학년 교과과정"
					onclick="submitForm('1grade', this)">1학년</button>
				<button type="button" data-value="2학년 교과과정"
					onclick="submitForm('2grade', this)">2학년</button>
				<button type="button" data-value="3학년 교과과정"
					onclick="submitForm('3grade', this)">3학년</button>
				<button type="button" data-value="전공심화 교과과정"
					onclick="submitForm('4grade', this)">전공심화</button>
			</div>
		</div>

		<div class="dropdown">
			<button type="button" class="btn btn-dark btn-pad">
				<span class="dropbtn_icon"></span> 커뮤니티
			</button>
			<div class="dropdown-content">
				<button type="button" data-value="공지사항"
					onclick="submitForm('notice', this)">공지사항</button>
				<button type="button" data-value="FAQ"
					onclick="submitForm('faq', this)">FAQ</button>
				<button type="button" data-value="자유게시판"
					onclick="submitForm('free', this)">자유게시판</button>
			</div>
		</div>

		<div class="dropdown">
			<button type="button" data-value="오시는 길" class="btn btn-dark btn-pad"
				onclick="submitForm('comToInhatc', this)">
				<span class="dropbtn_icon"></span> 오시는 길
			</button>
		</div>
	</form>

	<!-- 회원가입 버튼 -->
	<c:if test="${empty sessionScope.currentUser}">
		<button type="button" class="btn btn-dark btn-pad"
			onclick="location.href='register'">
			<span class="dropbtn_icon"></span> 회원가입
		</button>
	</c:if>

	<!-- 로그인 버튼 -->
	<c:if test="${empty sessionScope.currentUser}">
		<button type="button" class="btn btn-dark btn-pad"
			onclick="location.href='login'">
			<span class="dropbtn_icon"></span> 로그인
		</button>
	</c:if>

	<!-- 로그아웃 버튼 -->
	<c:if test="${not empty sessionScope.currentUser}">
		<button type="button" class="btn btn-dark btn-pad"
			onclick="location.href='logout'">
			<span class="dropbtn_icon"></span> 로그아웃
		</button>
	</c:if>

	<!-- 회원정보 버튼 -->
	<c:if test="${not empty sessionScope.currentUser}">
		<button type="button" class="btn btn-dark btn-pad"
			onclick="location.href='profile'">
			<span class="dropbtn_icon"></span> 회원정보
		</button>
	</c:if>

	<!-- 내게시글 버튼 -->
	<c:if test="${not empty sessionScope.currentUser}">
		<button type="button" class="btn btn-dark btn-pad"
			onclick="location.href='myboard'">
			<span class="dropbtn_icon"></span> 내게시글
		</button>
	</c:if>


	<script>
		function submitForm(category, button) {
			document.getElementById('boardCategory').value = category;
			document.getElementById('buttonValue').value = button
					.getAttribute('data-value');
			document.getElementById('categoryForm').submit();
		}
	</script>
</body>
</html>