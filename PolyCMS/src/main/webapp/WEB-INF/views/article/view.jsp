<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title></title>
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="/js/article_count.js"></script>
<script>


</script>
</head>
<body>
	<div>
			<div>
				<label>제목</label>
				<div>${item.subject}</div>
			</div>
			
			<div>
				<label>내용</label>
				<div>${item.contents}</div>
			</div>
			
			<div>
				<button class="btn btn-primary"id="good_count">좋아요</button>
				<button class="btn btn-primary" id="bad_count">싫어요</button>
			</div>
			<div style="display:flex;">
				<div style="display:flex;">
					<div>좋아요: </div>
					<div id="good_count_count">&nbsp;${item.goodCount}&nbsp;&nbsp;</div>
				</div>
				<div style="display:flex;">
					<div>싫어요:</div>
					<div id="bad_count_count">&nbsp;${item.badCount} </div>
				</div>
			</div>
			
			<div>
				<a href="../list">목록</a>
			</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>