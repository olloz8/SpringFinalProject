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
		<form action="actionEdit" method="post" class="formposition">
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">작성자</label>
				  <input name="userId" type="text" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${view.userId }" readonly>
			</div>
			
			<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">제목</label>
				  <input name="title" type="text" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${view.title }">
			</div>
			
			<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
				  <textarea name="boardContent" class="form-control formwidth viewcontent" id="exampleFormControlTextarea1" rows="3">${view.boardContent }</textarea>
			</div>
			<!-- 글 수정 버튼 클릭시, board의 고유 ID값을 통해 글을 수정합니다.	 -->
			<input type="hidden" name="boardID" value="${view.boardID }"> 	
			<input type="submit" value="글수정" class="btn btn-dark btn-position">
		</form>
		
		
		
</body>
</html>