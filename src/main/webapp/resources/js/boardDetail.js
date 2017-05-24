/**
 * 
 */

var boardDetail = function(){
	
	common.call(this);
	
	var self = this;
	
	var parameterMap = {};
	
	var $viewTitle = $(".viewTitle"),
		$viewWriter = $(".viewWriter"),
		$viewContent = $(".viewContent"),
		$viewRegDate = $(".viewRegDate"),
		$viewFile = $(".viewFile"),
		$file = $(".file"),
		$modifyBtn = $(".modifyBtn"),
		$detailView = $(".detailView"),
		$detailModify = $(".detailModify"),
		$replyContainer = $(".replyContainer"),
		$replyBtn = $("#replyBtn"),
		$replyContent = $("#replyContent"),
		$modifyTitle = $(".modifyTitle"),
		$modifyContent = $(".modifyContent"),
		$modifyFile = $(".modifyFile"),
		$updateBtn = $("#updateBtn"),
		$updateForm = $(".updateForm"),
		$bno = $(".bno"),
		$boardValue = $(".boardValue");
	
	this.init = function(){
		setParamter();
		retreive();
		addEvent();
	};
	
	var setParamter = function(){
		parameterMap = self.util.getParameterMap();
	};
	
	var addEvent = function(){
		$modifyBtn.on("click",function(e){
			e.preventDefault();
			
			$detailView.removeClass("active");
			$detailModify.addClass("active");
			
			$bno.val(parameterMap["bno"]);
			$boardValue.val(parameterMap["boardvalue"]);
			
		});
		
		$viewFile.on("click",function(e){
			downloadFile();
		});
		
		$replyBtn.on("click",function(e){
			e.preventDefault();
			
			registerReply();
		});
		
		$updateBtn.on("click",function(e){
			e.preventDefault();
			
			updateItem();
		});
	};
	
	var retreive = function(){
		retreiveDetail();
		retreiveReply();
	};
	
	var retreiveDetail = function(){
		var param = {
				"bno" : parameterMap["bno"],
				"boardValue" : parameterMap["boardvalue"]
			};
			
			$.ajax({
				type : "GET",
				url : "getItem.json",
				data : param,
				datType : "json",
				success : function(data){
					displayResult(data.result);
				},
				error : function(xhr){
					console.log(xhr);
				},
				complete : function(){
					
				}
			});
	};
	
	var displayResult = function(data){
		
		if(data === null || data.length === undefined){
			
		}else{
			var item = data[0];
			$viewTitle.html(item["title"]),
			$viewWriter.html(item["writer"]),
			$viewContent.html(item["content"]),
			$viewRegDate.html(self.util.getDateTime(new Date(item["regDate"])));
			
			$modifyTitle.val(item["title"]);
			$modifyContent.val(item["content"]);
			
			if(item["file"] === undefined || item["file"] === null){
				$file.hide();
			}else{
				$viewFile.html(item["file"]);
				$(".link").attr("href","http://192.168.1.170:8080/board/downloadFile.json?fileName="+item["file"]);
				$file.show();
			}
		}
		
	};
	
	var retreiveReply = function(){
		var param = {
			"boardValue" : parameterMap["boardvalue"]
		};
		
		$.ajax({
			type : "POST",
			url : "getReplyList.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				displayReplyList(data.result);
			},
			error : function(xhr){
				console.log(xhr);
			},
			complete : function(){
				
			}
		});
	};
	
	var displayReplyList = function(data){
		$replyContainer.html("");
		
		if(data === null || data.length === undefined){
			
		}else{
			for(var i=0;i<data.length;i++){
				var div = $("<div></div>").addClass("chat-body"),
					li = $("<li></li>").addClass("left clearfix"),
					span = $("<span></span>").addClass("chat-img pull-left"),
					strong = $("<strong></strong>"),
					small = $("<small></small>").addClass("pull-right text-muted"),
					icon = $("<i></i>").addClass("fa fa-clock-o fa-fw"),
					p = $("<p></p>"),
					item = data[i];
				
				//var repl = div.clone().html(div.clone().html(item["replyWriter"])).append(div.clone().html(item["replyContent"])).append(div.clone().html(item["replyRegDate"]));
				li.html(span).append(div.html(strong.html(item["replyWriter"])).append(small.html(icon).append("시간")).append(p.html(item["replyContent"])));
				$replyContainer.append(li);
			}
		}
		
	};
	
	var registerReply = function(){
		var param = {
			"boardValue" : parameterMap["boardvalue"],
			"replyContent" : $replyContent.val()
		};
		
		$.ajax({
			type : "POST",
			url : "registerReply.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				clearForm();
				retreive();
			},
			error : function(xhr){
				console.lolg(xhr);
			},
			complete : function(){
				
			}
		});
	};
	
	var clearForm = function(){
		$replyContent.val("");
	};
	
	var updateItem = function(){
		
		var params = {};
		
		var formData = new FormData($updateForm[0]);
		
		$.ajax({
			type : "POST",
			url : "updateItem.json",
			data : formData,
			dataType : "json",
			processData : false,
			contentType : false,
			success : function(data){
				if(data.result === "success"){
					alert("수정이 완료되었습니다.");
				}else{
					alert("수정하는 도중에 오류가 발생하였습니다.");
				}
				window.location.reload();
			},
			error : function(xhr){
				console.log(xhr);
			},
			complete : function(){
				
			}
		});
	};
};