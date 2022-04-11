<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	#empty_box{
		width: 3px;
	}
</style>
</head>
<body>
	<div>
		<div>
			<h3>${boardId} 목록</h3>
		</div>
		<div>총 ${pager.total} 건</div>
		<div style="display: flex">
			<form>
				<div>
					<select name="search">
						<option value="0">전체</option>
						<option value="1">제목</option>
						<option value="2">내용</option>
						<option value="3">작성자</option>
					</select>
				</div>
				<div>
					<input type="text" name="keyword">
				</div>
				<div>
					<button>검색</button>
				</div>
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>		
						<th>관리</th>					
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<th colspan="5">등록 된 게시물이 없습니다</th>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.articleId}</td>
							<td><a href="view/${item.articleId}">${item.subject}</a></td>		
							<td>${item.memberId}</td>
							<td>${item.viewCount}</td>
							<td><a href="update/${item.articleId}">변경</a> <a href="delete/${item.articleId}">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="4">
							<div style="display: flex">
								<div><a href="?page=1">처음</a></div>
								<div id="empty_box"></div>
								<div><a href="?page=${pager.prev} ">이전</a></div>
								
								<c:forEach var="page" items="${pager.list}">
									<div><a href="?page=${page}">${page}</a></div>
								</c:forEach>
								
								<div><a href="?page=${pager.next} ">다음</a></div>
								<div id="empty_box"></div>
								<div><a href="?page=${pager.last} ">마지막</a></div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div style="display: flex;">
			<a href="dummy">대량추가</a>
											<div id="empty_box"></div>
			<a href="add">추가 </a>
											<div id="empty_box"></div>
			<a href="init">초기화</a>
			
		</div>
		
	</div>
</body>
</html>