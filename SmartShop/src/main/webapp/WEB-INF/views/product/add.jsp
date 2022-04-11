<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/header.jsp"></jsp:include>
<link
   href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
   rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
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
   })
</script>
</head>
<body>
   <div class="container">
      <form method="post" class="mt-4" enctype="multipart/form-data">
         <div class="mt-2 form-floating">
            <input type="text" id="name" name="name" class="form-control"
               placeholder="제품명"> <label>제품명:</label>
         </div>
         <div class="mt-2 form-floating">
            <input type="text" id="spec" name="spec" class="form-control"
               placeholder="규격"> <label>규격:</label>
         </div>
         <div class="mt-2 form-floating">
            <input type="text" id="category" name="category"
               class="form-control" placeholder="카테고리"> <label>카테고리:</label>
         </div>
         <div class="mt-2 form-floating">
            <input type="text" id="manufacture" name="manufacture"
               class="form-control" placeholder="제조사"> <label>제조사:</label>
         </div>
         <div class="mt-2 form-floating">
            <input type="number" id="price" name="price" class="form-control" value="0"
               placeholder="가격"> <label>가격:</label>
         </div>
         <div class="mt-2 form-floating">
            <input type="text" id="barcode" name="barcode" class="form-control"
               placeholder="바코드"> <label>바코드:</label>
         </div>
         <div class="mt-2">
            <label>제품설명</label>
            <textarea rows="20" cols="80" name="info" id="summernote"></textarea>
         </div>
         <div class="mt-2">
            <label>제품이미지:<span id="add_image" class="btn btn-outline-primary btn-sm">추가</span></label> 
               <input type="file" name="productImage" class="form-control">
         </div>

         <div class="row mt-4">
            <div class="col"></div>
            <div class="col">
               <button class="btn btn-primary form-control">등록</button>
            </div>
            <div class="col"></div>
         </div>
      </form>

   </div>
   <jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>