<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssWriteBoard.css">
<body>		
		<form action="actionWriteBoard" method="post" class="formposition">
<!-- 			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">작성자</label>
				  <input name="userId" type="text" class="form-control formwidth" id="exampleFormControlInput1" placeholder="작성자명">
			</div> -->
			
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">제목</label>
				  <input name="title" type="text" class="form-control formwidth" id="exampleFormControlInput1" placeholder="제목">
			</div>
			
			<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
				  <textarea name="boardContent" class="form-control formwidth" id="exampleFormControlTextarea1" rows="3" placeholder="글내용"></textarea>
			</div>
			
			<input type="hidden" name="boardCategory" value="${boardCategory }">
			<input type="submit" value="글작성" class="btn btn-dark btn-position">
		</form>
		
		
		
</body>
</html>