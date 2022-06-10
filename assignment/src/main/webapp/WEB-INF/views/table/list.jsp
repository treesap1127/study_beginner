<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script></script>
<script src="js/drag_order_dom.js"></script>
<style>
	table{
		text-align:center;
	}
	.bigbtn{
		width: 100%;
		height: 100px
	}
</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
	<div style="display:flex">
		<h1>고객 리스트</h1>
		<form style="display:flex">
			<div>
				<select name="search">
					<option value="0">검색항목</option>
					<option value="1" ${pager.search==1?'selected':''}>고객명</option>
					<option value="2" ${pager.search==2?'selected':''}>전화번호</option>
					</select> 
			</div>
				<div><input type="text" name="keyword" value="${pager.keyword}"></div>
				<div><button class="btn btn-dark">검색</button></div>
			</form>
			<h1> 위 리스트는 순서를 drag and drop 으로 바꿀 수 있습니다!</h1>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>고객번호</th>
					<th>고객명</th>
					<th>전화번호</th>
					<th>관리</th>
				</tr>
			</thead>
			
			<tbody>
			<c:if test="${list.size()<1 }">
				<tr>
					<td colspan="4">등록 된 고객이 없습니다.</td>
				</tr>
				</c:if>
			<c:forEach items="${list}" var="item" >
				<tr class="dragItem">
					<td>${item.num}</td>
					<td>${item.name}</td>
					<td>${item.tel}</td>
					<td><a href="delete/${item.num}"><button class="btn btn-danger">삭제</button></a><a href="update/${item.num}"><button class="btn btn-warning">변경</button></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<button class="btn btn-dark bigbtn" onclick="check()">적용</button>
		<a href="add"><button class="btn btn-primary bigbtn">추가</button></a>
		<a href="../"><button class="btn btn-danger bigbtn">뒤로가기</button></a>
	</div>
	   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	<script>
	new DragOrder("tbody");
</script>
</body>
</html>