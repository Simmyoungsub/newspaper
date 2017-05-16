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
		$detailModify = $(".detailModify");
	
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
	};
	
	var retreive = function(){
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
	
	var downloadFile = function(){
		
		var param = {
			"fileName" : $viewFile.text()	
		};
		
//		$.ajax({
//			type : "GET",
//			url : "downloadFile.json",
//			data : param,
////			contentType:"application/json",
//			datType : "json",
//			success : function(data){
//				console.log(data);
//			},
//			error : function(xhr){
//				console.log(xhr);
//			},
//			complete : function(){
//				
//			}
//		});
		
	};
	
};