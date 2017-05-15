<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/boardDetail.css"/>" type="text/css"/>
<script type="text/javascript" src="<c:url value="/resources/js/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/boardDetail.js"/>"></script>
<body>
	<div>
		<div>
			<div>
				<div class="detailView">
					<form>
						<div class="label">
							<label>제목</label>
						</div>
						<div class="field">
							<label class="viewTitle"></label>
						</div>
						<div class="label">
							<label>작성자</label>
						</div>
						<div class="field">
							<label class="field viewWriter"></label>
						</div>
						<div class="label">
							<label>등록날짜</label>
						</div>
						<div class="field">
							<label class="field viewRegDate"></label>
						</div>
						<div class="label">
							<label>내용</label>
						</div>
						<div class="field">
							<label class="field viewContent"></label>
						</div>
						<div class="label file">
							<label>첨부파일</label>
						</div>
						<div class="field file">
							<label class="field viewFile"></label>
						</div>
					</form>
				</div>
				<div class="detailModfy" style="display:none;">
					<form>
						<div>
							<label for="title">제목</label>
						</div>
						<div>
							<input type="text" name="title" id="title" class="title">
						</div>
						<div>
							<label for="content">내용</label>
						</div>
						<div>
							<textarea name="content" id="content" class="content"></textarea>
						</div>
						<div>
							<label for="file">첨부파일</label>
						</div>
						<div>
							<input type="file" name="file" id="file" class="file"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>

$(document).ready(function(){
	var b = new boardDetail();
	b.init();
});

</script>
</html>