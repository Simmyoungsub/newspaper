<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value="/resources/css/board.css"/>" type="text/css"/>
<script type="text/javascript" src="<c:url value="/resources/js/board.js"/>"></script>
	<div>
		<div>
			<div>
				<div class="row">
	                <div class="col-md-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                             	DashBoard
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="list table table-striped table-bordered table-hover" id="dataTables-example">
	                                </table>
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
	var b = new board();
	b.init();
});

</script>
