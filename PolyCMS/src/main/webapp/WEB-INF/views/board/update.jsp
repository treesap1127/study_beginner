<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>게시판 변경</h3>
		</div>
		<form method="post">
			<div>
				<label>게시판명</label>
				<input type="text" name="subject" value="${item.subject}">
			</div>
			
			<div>
				<label>댓글 허용</label>
				<select name="reply">
					<option value="0" ${item.reply == '0'.charAt(0) ? 'selected' : ''}>댓글 불가</option>
					<option value="1" ${item.reply == '1'.charAt(0) ? 'selected' : ''}>댓글 허용</option>
				</select>
			</div>
			
			<div>
				<label>첨부파일 허용</label>
				<select name="attach">
					<option value="0" ${item.reply == '0'.charAt(0) ? 'selected' : ''}>첨부파일 불가</option>
					<option value="1" ${item.reply == '1'.charAt(0) ? 'selected' : ''}>단일파일 허용</option>
					<option value="2" ${item.reply == '2'.charAt(0) ? 'selected' : ''}>다중파일 허용</option>
				</select>
			</div>
			
			<div>
				<label>공개여부</label>
				<select name="secret">
					<option value="0" ${item.reply == '0'.charAt(0) ? 'selected' : ''}>비공개</option>
					<option value="1" ${item.reply == '1'.charAt(0) ? 'selected' : ''}>공개</option>
				</select>
			</div>
			
			<div>
				<label>권한</label>
				<select name="permission">
					<option value="0" ${item.reply == '0'.charAt(0) ? 'selected' : ''}>쓰기 불가</option>
					<option value="1" ${item.reply == '1'.charAt(0) ? 'selected' : ''}>쓰기 허용</option>
				</select>
			</div>
			
			<div>
				<button>변경</button>
				<button type="button">취소</button>
			</div>
		</form>
	</div>
</body>
</html>