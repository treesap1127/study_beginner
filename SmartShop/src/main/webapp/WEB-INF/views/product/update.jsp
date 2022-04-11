<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/header.jsp"></jsp:include>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
	$(function() {
		$('#summernote').summernote();

		$("#add_image").click(function() {
			const div = $("<div>").addClass("mt-2");
			const label = $("<label>").text("제품이미지");
			const button = $("<span>").text("삭제");

			button.addClass("btn btn-outline-primary btn-sm");
			const file = $("<input>").attr("type", "file");
			file.attr("name", "productImage");
			file.addClass("form-control");

			button.click(function() {
				$(this).parent().remove();
				
			});

			div.append(label);
			div.append(button);
			div.append(file);

			$("form > div:last-child").before(div);
		});
		
		$("button.delete").click(function(){
			const code =$(this).data("code");//이걸로 코드값을 얻네 data-code로 받은값
			
			$.ajax("../image/delete/"+code,{
				method:"GET",
				success:function(result){
					console.log(typeof(result));
					console.log(result);
					
					if(result)
						$("button.delete[data-code='"+code+"']").parent().remove();
				},
				error:function(jqxhr, status){
					alert.log(status);
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-4" enctype="multipart/form-data">
			<div class="input-group mt-2">
				<label class="input-group-text col-2">제품명:</label> <input
					type="text" name="name" class="form-control" value="${item.name}">
			</div>
			<div class="mt-2 input-group">
				<label class="input-group-text col-2">규격:</label> <input type="text"
					name="spec" class="form-control" value="${item.spec}">
			</div>
			<div class="mt-2 input-group">
				<label class="input-group-text col-2">카테고리:</label> <input
					type="text" name="category" class="form-control"
					value="${item.category}">
			</div>
			<div class="mt-2 input-group">
				<label class="input-group-text col-2">제조사:</label> <input
					type="text" name="manufacture" class="form-control"
					value="${item.manufacture}">
			</div>
			<div class="mt-2 input-group">
				<label class="input-group-text col-2">가격:</label> <input
					type="number" name="price" class="form-control"
					value="${item.price}">
			</div>
			<div class="mt-2">
				<label>제품설명:</label>
				<textarea rows="50" cols="80" name="info" id="summernote">${item.info}</textarea>
			</div>

			<div class="mt-2">
			
		<div>
 			<ul>
 				<c:if test="${item.images==null||item.images.size()<1}">
 				<li>등록 된 제품이미지가 없습니다</li>
 				</c:if>
 				<c:forEach var="image" items="${item.images}">
 				<li><button type="button" class="btn btn-sm btn-danger delete" data-code="${image.code}">삭제</button>${image.filename}</li>
 				</c:forEach>
 			
 			</ul>
 		</div>
 				<div>
				<label>제품이미지:
					<span id="add_image" class="btn btn-outline-primary btn-sm">추가</span>
					</label> <input type="file" name="productImage" class="form-control">
					</div>
			</div>

			<div class="row mt-4">
				<div class="col"></div>
				<div class="col">
					<button class="btn btn-primary form-control">변경</button>
				</div>
				<div class="col"></div>
			</div>
		</form>
	</div>
	<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>