<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기 페이지</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssWriteBoard.css">
<body>
<form id="boardForm" method="post" class="formposition">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">작성자</label>
        <input name="userId" type="text" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${view.userId }" readonly>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">제목</label>
        <input name="title" type="text" class="form-control formwidth viewcontent" id="exampleFormControlInput1" value="${view.title }" readonly>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
        <textarea name="boardContent" class="form-control formwidth viewcontent" id="exampleFormControlTextarea1" rows="3" readonly>${view.boardContent }</textarea>
    </div>
    <input type="hidden" name="boardID" value="${view.boardID }">
    <input type="hidden" name="boardCategory" value="${view.boardCategory }">
    <c:choose>
        <c:when test="${not empty userId && userId eq 'ADMIN'}">
            <input type="hidden" name="boardCategory" value="${view.boardCategory }">
            <button type="button" onclick="submitForm('editBoard')" class="btn btn-dark btn-position">글수정</button>
            <button type="button" onclick="submitForm('deleteBoard')" class="btn btn-dark btn-position marginButton">글삭제</button>
        </c:when>
        <c:when test="${view.boardCategory eq 'notice' || view.boardCategory eq 'faq' || view.boardCategory eq 'free'}">
            <input type="hidden" name="boardCategory" value="${view.boardCategory }">
            <button type="button" onclick="submitForm('editBoard')" class="btn btn-dark btn-position">글수정</button>
            <button type="button" onclick="submitForm('deleteBoard')" class="btn btn-dark btn-position marginButton">글삭제</button>
        </c:when>	
    </c:choose>
	<button type="button" onclick="submitForm('board')" class="btn btn-dark btn-position marginButton">목록</button>
</form>
<script>
    function submitForm(action) {
        var form = document.getElementById('boardForm');
        form.action = action;
        form.submit();
    }

</script>
</body>
</html>