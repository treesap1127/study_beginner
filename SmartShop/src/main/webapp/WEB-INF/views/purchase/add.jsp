<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
<body>
   <div class="container">
   	<div>
   		<h3>입고내역 등록 (${user})</h3>
   	</div>
      <form method="post" class="mt-4">
         <div class="mt-2">
            <label>제품번호:</label>
            <select name="product" class="form-select">
            	<c:forEach var ="item" items="${listProduct}">
            		<option value="${item.code}">${item.name}</option>	
            	</c:forEach>
            </select>
            
         </div>
         <div class="mt-2">
            <label>거래처:</label>
            <select name="partner" class="form-select">
            	<c:forEach var = "item" items="${listPartner}">
            		<option value="${item.code}">${item.name}</option>           	
            	</c:forEach>
            </select>
         </div>
         <div class="mt-2 form-floating">
            <input type="number" name="amount" class="form-control" placeholder="수량">
            <label>수량:</label>
         </div>
         <div class="row mt-4">
         <div class="col"></div>
         <div class="col"><button class="btn btn-primary form-control">등록</button></div>
         <div class="col"></div>
         </div>
      </form>
   </div>
<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>