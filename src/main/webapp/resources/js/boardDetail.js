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
		$replyContent = $("#replyContent");
	
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
			
			$detailView.removeClass("active");
			$detailModify.addClass("active");
			
		});
		
		$viewFile.on("click",function(e){
			downloadFile();
		});
		
		$replyBtn.on("click",function(e){
			registerReply();
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
			$viewRegDate.html(item["regDate"]);
			
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
				var div = $("<div></div>"),
					item = data[i];
				
				var repl = div.clone().html(div.clone().html(item["replyWriter"])).append(div.clone().html(item["replyContent"])).append(div.clone().html(item["replyRegDate"]));
				
				$replyContainer.append(repl);
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
};