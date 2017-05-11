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
<script type="text/javascript" src="<c:url value="/resources/js/boardRegister.js"/>"></script>
<style>
	table{border-collapse: collapse;}
	table tr td,th{border:1px solid black;}
</style>
<body>
	<div>
		<div>
			<div>
				<div>
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
					</form>
					<div>
						<div style="display:inline-block;">
							<button id="registerBtn">등록</button>
						</div>
						<div style="display:inline-block;">
							<button>취소</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>

$(document).ready(function(){
	var b = new boardRegister();
	b.init();
});

</script>
</html>