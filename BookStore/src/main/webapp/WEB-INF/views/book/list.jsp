<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookstore</title>
</head>
<body>
	<h1>도서 목록</h1>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>출판사</th>
					<th>가격</th>
					<th>관리</th>
				</tr>
			</thead>
			
			<tbody>
			<c:if test="${list.size()<1 }">
				<tr>
					<td colspan="5">등록 된 도서가 없습니다.</td>
				</tr>
				</c:if>
				<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.bookid}</td>
					<td>${item.bookname}</td>
					<td>${item.publisher}</td>
					<td>${item.price}</td>
					<td><a href="update/${item.bookid}">변경</a> <a href="delete/${item.bookid}">삭제</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<a href="add">등록</a> <a href="..">처음으로</a>
	</div>
</body>
</html>