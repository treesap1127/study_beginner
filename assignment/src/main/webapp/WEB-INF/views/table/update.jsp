<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>고객 수정</h1>
		<form method="post">
			<div>
				<div>
					<label>고객명:</label>
					<input name="name" type="text" value="${item.name}">
				</div>
				<div>
					<label>전화번호:</label>
					<input name="tel" type="text" value="${item.tel}">
				</div>
				<div>
					<button>등록</button>
					<a href="../list"><button type="button">취소</button></a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>