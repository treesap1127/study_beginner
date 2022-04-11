<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<c:if test="${sessionScope.member !=null}">
			<div>
				<span>${sessionScope.member.id}</span><span>님 환영 합니다</span>
			</div>
			<div>
				<a href="logout">로그아웃</a>
			</div>
		</c:if>
	<c:if test="${sessionScope.member ==null}">
		<div>
			<a href="login">로그인</a>
		</div>
	</c:if>
		<div>
			<a href="book">도서관리</a>
			<a href="customer">고객관리</a>
			<a href="order">주문관리</a>
			<a href="order/info">주문내역</a>
		</div>
	</div>
</body>
</html>