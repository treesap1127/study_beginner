<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<style>
	table{
		text-align:center;
	}
	.bigbtn{
		width: 100%;
		height: 100px
	}
</style>
	<title></title>
</head>
<body>
	<div>
		<a href="list"><button class="btn btn-primary bigbtn">게시판 들어가기</button></a>
	</div>
	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>순번</th>
					<th>고객명</th>
					<th>전화번호</th>
				</tr>
			</thead>

			<tbody>
					<c:if test="${list.size()<1 }">
				<tr>
					<td colspan="4">등록 된 고객이 없습니다.</td>
				</tr>
				</c:if>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.num}</td>
					<td>${item.name}</td>
					<td>${item.tel}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	
</body>
</html>