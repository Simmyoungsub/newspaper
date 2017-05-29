<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>" type="text/css"/>
<script type="text/javascript" src="<c:url value="/resources/js/login.js"/>"></script>
<div>
	<div class="rowWrapper">
		<div class="row">
            <div class="col-md-12">
				<form role="form">
                    <div class="form-group">
                        <label class="control-label" for="inputSuccess">아이디</label>
                        <input type="text" class="form-control" id="userId" placeholder="아이디를 입력하세요.">	
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputWarning">비밀번호</label>
                        <input type="password" class="form-control" id="userPassword" placeholder="비밀번호를 입력하세요.">
                    </div>
                </form>
                <div class="btnContainer">
                	<div class="btnWrapper">
                		<a href="#" id="loginBtn" class="btn btn-primary">로그인</a>
                	</div>
                	<div class="btnWrapper">
                		<a href="#" class="btn btn-primary">취소</a>
                	</div>
                </div>
            </div>
       	</div>
	</div>
</div>
<script>

$(document).ready(function(){
	var b = new board_login();
	b.init();
});

</script>
