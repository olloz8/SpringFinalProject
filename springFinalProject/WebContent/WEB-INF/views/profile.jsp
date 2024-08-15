<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기 페이지</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssWriteBoard.css">
<body>		
   
    <form id="profileForm" method="post" class="formposition">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">아이디</label>
            <input name="userId" type="text" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${user.userId }" readonly>
        </div>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
            <input name="password" type="password" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${user.password }" readonly>
        </div>

        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">이름</label>
			<input name="userName" type="text" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${user.userName }" readonly>
        </div>

	<c:if test="${not empty sessionScope.currentUser}">
<button type="button" class="btn btn-dark btn-pad" onclick="location.href='${pageContext.request.contextPath}/editprofile'">
    <span class="dropbtn_icon"></span> 수정
</button>
	</c:if>
	
    </form>		
</body>
</html>