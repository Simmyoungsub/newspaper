<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/board.css"/>" type="text/css"/> --%>
<script type="text/javascript" src="<c:url value="/resources/js/calendar.js"/>"></script>
	<div>
		<div>
			<div class="row">
                <table class="result">
                </table>
           	</div>
		</div>
		<div>
			<div class="yyyy-mm-dd">
			</div>
		</div>
	</div>
<script>

$(document).ready(function(){
	var b = new calendar();
	b.init();
});

</script>
