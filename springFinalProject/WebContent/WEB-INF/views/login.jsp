<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssWriteBoard.css">
<body>		
		<form action="login" method="post" class="formposition">
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">아이디</label>
				  <input name="userId" type="text" class="form-control formwidth" id="exampleFormControlInput1" placeholder="아이디">
			</div>
			
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
				  <input name="password" type="password" class="form-control formwidth" id="exampleFormControlInput1" placeholder="비밀번호">
			</div>
			
			<input type="submit" value="로그인하기" class="btn btn-dark btn-position">
		</form>
		
    <c:if test="${not empty script}">
        <script>
            ${script}
        </script>
    </c:if>
    
</body>
</html>