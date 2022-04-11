<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
<jsp:include page="../include/header.jsp"></jsp:include>
<script>
$(function(){
	$("thead input[type='checkbox']").on("change",function(){
	    const checked =$(this).prop("checked");

	    $(".item-check").prop("checked",checked);
	 });
	$("#delete_list").click(()=> $("#delete_form").submit());
});

</script>
</head>
<body>
	<div >
		<h3>제품목록</h3>
		<div class="mb-2">
			<form class="row">
			<div class="col-6"></div>
			<div class="col-auto">
				<select name="search" class="form-select">
					<option value="0">검색항목</option>
					<option value="1" ${pager.search==1?'selected':''}>제품번호</option>
					<option value="2" ${pager.search==2?'selected':''}>제품명</option>
					<option value="3" ${pager.search==3?'selected':''}>규격</option>
					<option value="4" ${pager.search==4?'selected':''}>카테고리</option>
					<option value="5" ${pager.search==5?'selected':''}>제조사</option>
					</select> 
						</div>
				<div class="col-auto"><input type="text" name="keyword" value="${pager.keyword}" class="form-control"></div>
				<div class="col-auto"><button class="btn btn-dark">검색</button></div>
			</form>
		</div>
	</div>
	<div>
		<table border="1" class="table table-sm" >
			
		 	<thead class="table-dark">
				<tr>
					<th><input type="checkbox" class="form-check-input"></th>
					<td>제품번호</td>
					<td>제품명</td>
					<td>규격</td>
					<td>카테고리</td>
					<td>재조사</td>
					<td>가격</td>
					<td>관리</td>
				</tr>
			</thead>
			<form id="delete_form" method="post" action="delete_list">
			<tbody>
				<c:forEach var="item" items="${list}">
					<!-- list를 items에 제이쿼리로 넘김 item선언은 덤 반복!시작! -->
					<tr>
						<!--  여기서 내용을 담아줌! -->
						<td><input type="checkbox" class="form-check-input item-check" name="code" value="${item.code}"></td>
						<td>${item.code}</td>
						<td><a href="view/${item.code}">${item.name}</a></td>
						<td>${item.spec}</td>
						<td>${item.category}</td>
						<td>${item.manufacture}</td>
						<td><fmt:formatNumber value="${item.price}"></fmt:formatNumber> </td>
						<td><a href="delete/${item.code}" class="btn btn-sm btn-danger">삭제</a> <a
							href="update/${item.code}" class="btn btn-sm btn-warning">변경</a></td>
					</tr>
					<!-- 딜리트 버튼 누르면 바로 보내네  update누르면 update로 바로보냄-->
				</c:forEach>
				<c:if test="${list.size() < 1}">
					<!-- list의 길이가  -->
					<tr>
						<td colspan="7">등록 된 제품이 없습니다</td>
					</tr>
				</c:if>
				</tbody>
			</form>
			<tfoot>
				<tr>
					<td colspan="7">
					<div class="pagination justify-content-center" >
						<div class="page-item"><a href="?page=1${pager.query}" class="page-link">처음</a></div>
						<div class="page-item"><a href="?page=${pager.prev}${pager.query}" class="page-link">이전</a></div> 
						<c:forEach var="page" items="${pager.list}">
							<div class="page-item ${page == pager.page ? 'active':''}"><a href="?page=${page}${pager.query}" class="page-link">${page}</a></div>
						</c:forEach>

						<div class="page-item"><a href="?page=${pager.next}${pager.query}" class="page-link">다음</a></div>
						<div class="page-item"><a href="?page=${pager.last}${pager.query}" class="page-link">마지막</a>
						</div>
					</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div>
		<a href="add" class="btn btn-sm btn-primary">등록</a>
		<a href="dummy" class="btn btn-sm btn-info">대량등록</a>
		<a href="init" class="btn btn-sm btn-danger">초기화</a>
		<button id="delete_list" class="btn btn-sm btn-danger">선택삭제</button>
		<a href=".." class="btn btn-sm btn-primary">이전메뉴</a></div>
<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>