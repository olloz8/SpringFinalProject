<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인하공업전문대학 컴퓨터정보공학과 - ${CategoryName }</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssBoard.css">
<body>
    <div class="board_css">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Writer</th>
                    <th scope="col">Title</th>
                    <th scope="col">Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var='board_item' items='${myBoards}'>
                    <tr>
                        <td>${board_item.userId }</td>
                        <td><a href="viewBoard?boardID=${board_item.boardID }" class="a-css">${board_item.title }</a></td>
                        <td>${board_item.nowDate }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="../springFinalProject" class="button" style="text-decoration:none; color:#fff">메인으로 이동</a>
    </div>
</body>
</html>