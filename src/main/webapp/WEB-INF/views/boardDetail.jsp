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
				<div class="detailView active">
					<!-- <div>
						<button class="modifyBtn">수정</button>
					</div>
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
							<a class="link"><label class="field viewFile"></label></a>
						</div>
					</form>
					<div>
						<div>
							<div class="replyContainer">
							</div>
						</div>
					</div>
					<div>
						<div>
							<div>
								<label>댓글 내용</label>
							</div>
							<div>
								<textarea id="replyContent"></textarea>
							</div>
							<div> 
								<button id="replyBtn">확인</button>
							</div>
						</div>
					</div> -->
					<div class="row">
	                    <div class="col-md-12">           
							<div class="panel panel-back noti-box">
	                			<span class="icon-box bg-color-blue">
	                    			<i class="fa fa-warning"></i>
	               	 			</span>
	                			<div class="text-box" >
	                    			<p class="viewTitle main-text"></p>
	                   	 			<p class="viewWriter text-muted"></p>
	                    			<p class="viewRegDate text-muted"></p>
	                    			<hr />
			                    	<p class="text-muted">
			                        	 <span class="viewContent text-muted color-bottom-txt"><i class="fa fa-edit"></i>
			                         	 </span>
			                   		 </p>
			                   		 <div class="btnContainer">
				                   		 <div class="btnWrapper">
				                   		 	<a href="#" class="modifyBtn btn btn-primary">수정</a>
				                   		 </div>
			                   		 </div>
	                			</div>
	                		</div>
	                	</div>
	            	</div>
	            	<div class="row">
	            		<div class="col-md-12">
	            			<div class="panel panel-default">
	            				<div class="panel-heading">
	            					댓글
	            				</div>
	            				<div class="panel-body">
			            			<ul class="replyContainer chat-box">
		                                <li class="left clearfix">
		                                    <span class="chat-img pull-left">
		                                        <img src="assets/img/1.png" alt="User" class="img-circle" />
		                                    </span>
		                                    <div class="chat-body">                                        
	                                            <strong >Jack Sparrow</strong>
	                                            <small class="pull-right text-muted">
	                                                <i class="fa fa-clock-o fa-fw"></i>12 mins ago
	                                            </small>                                      
		                                        <p>
		                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
		                                        </p>
		                                    </div>
		                                </li>
		                             </ul>
	                             </div>
                             </div>
	            		</div>
	            	</div>
	            	<div class="row">
	                    <div class="col-md-12">
	                    	<h3>댓글 작성</h3>
		                    <form role="form" enctype="multipart/form-data" class="registerForm">
		                        <div class="form-group">
		                            <label for="content"></label>
		                            <textarea class="content form-control" rows="10" name="replyContent" id="replyContent"></textarea>
		                        </div>
		                     </form>
		                     <div>
		                     	<a href="#" id="replyBtn" class="replyBtn btn btn-primary">등록</a>
		                     </div>
	                    </div>
	                </div>
				</div>
				<div class="detailModify">
					<div class="row">
		                <div class="col-md-12">
		                    <h3>게시글 수정</h3>
		                    <form role="form" enctype="multipart/form-data" class="updateForm">
		                        <div class="form-group">
		                            <label for="title">제목</label>
		                            <input class="modifyTitle form-control" placeholder="제목을 입력해주세요." name="title" id="title"/>
		                        </div>
		                        <div class="form-group">
		                            <label for="content">내용</label>
		                            <textarea class="modifyContent form-control" rows="10" name="content" id="content"></textarea>
		                        </div>
		                        <div class="form-group">
		                            <label for="file">첨부 파일</label>
		                            <input type="file"  name="file" id="file" class="modifyFile"/>
		                        </div>
		                        <input type="hidden" name="bno" class="bno" value="" />
		                        <input type="hidden" name="boardValue" class="boardValue" value="" />
		                   	</form>
		                   	<div class="btnContainer">
								<div style="display:inline-block;" class="btnWrapper">
									<a id="" class="btn btn-default">취소</a>
								</div>
								<div style="display:inline-block;" class="btnWrapper">
									<a id="updateBtn" class="btn btn-primary">수정</a>
								</div>
							</div>
		               	</div>
	            	</div>
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