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
		$file = $(".file");
	
	this.init = function(){
		setParamter();
		retreive();
		addEvent();
	};
	
	var setParamter = function(){
		parameterMap = self.util.getParameterMap();
	};
	
	var addEvent = function(){
		
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
				$file.show();
			}
		}
		
	};
};