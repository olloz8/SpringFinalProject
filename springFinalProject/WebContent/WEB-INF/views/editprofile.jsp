<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssWriteBoard.css">
<body>		
    <form:form action="editprofile" method="post" modelAttribute="user" class="formposition">
        <div class="mb-3">
            <label for="userId" class="form-label">아이디</label>
            <form:input path="userId" type="text" class="form-control formwidth viewcontent" id="userId" />
        </div>
        
        <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <form:input path="password" type="password" class="form-control formwidth viewcontent" id="password" />
        </div>
        
        <div class="mb-3">
            <label for="userName" class="form-label">이름</label>
            <form:input path="userName" type="text" class="form-control formwidth viewcontent" id="userName" />
        </div>
        
        <input type="submit" value="수정완료" class="btn btn-dark btn-position">
    </form:form>
		
		
		
</body>
</html>