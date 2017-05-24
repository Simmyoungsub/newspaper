<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value="/resources/css/boardRegister.css"/>" type="text/css"/>
<script type="text/javascript" src="<c:url value="/resources/js/boardRegister.js"/>"></script>
<style>
	table{border-collapse: collapse;}
	table tr td,th{border:1px solid black;}
</style>
<div>
	<div>
		<div>
			<div>
				<!-- <form enctype="multipart/form-data" class="registerForm">
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
				<div>
					<div style="display:inline-block;">
						<button id="registerBtn">등록</button>
					</div>
					<div style="display:inline-block;">
						<button>취소</button>
					</div>
				</div> -->
			</div>
			<div>
				<div class="row">
	                <div class="col-md-12">
	                    <h3>게시글 작성</h3>
	                    <form role="form" enctype="multipart/form-data" class="registerForm">
	                        <div class="form-group">
	                            <label for="title">제목</label>
	                            <input class="title form-control" placeholder="제목을 입력해주세요." name="title" id="title"/>
	                        </div>
	                        <div class="form-group">
	                            <label for="content">내용</label>
	                            <textarea class="content form-control" rows="10" name="content" id="content"></textarea>
	                        </div>
	                        <div class="form-group">
	                            <label for="file">첨부 파일</label>
	                            <input type="file"  name="file" id="file" class="file"/>
	                        </div>
	                   	</form>
	                   	<div class="btnContainer">
							<div style="display:inline-block;" class="btnWrapper">
								<a id="" class="btn btn-default">취소</a>
							</div>
							<div style="display:inline-block;" class="btnWrapper">
								<a id="registerBtn" class="btn btn-primary">등록</a>
							</div>
						</div>
	               	</div>
	            </div>
			</div>
		</div>
	</div>
</div>
<script>

$(document).ready(function(){
	var b = new boardRegister();
	b.init();
});

</script>
