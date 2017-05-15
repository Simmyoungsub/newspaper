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
<link rel="stylesheet" href="<c:url value="/resources/css/board.css"/>" type="text/css"/>
<script type="text/javascript" src="<c:url value="/resources/js/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/board.js"/>"></script>
<body>
	<div>
		<div>
			<div>
				<div>
					<button id="registerBtn">등록</button>
				</div>
				<div>
					<table class="list">
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script>

$(document).ready(function(){
	var b = new board();
	b.init();
});

</script>
</html>