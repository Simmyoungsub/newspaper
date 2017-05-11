/**
 * 
 */

var board = function(){
	
	var $registerBtn = $("#registerBtn");
	
	this.init = function(){
		addEvent();
	};
	
	var addEvent = function(){
		$registerBtn.on("click",function(){
			location.href="boardRegister.page";
		});
	};
	
	var retreive = function(){
		
		var param = {
				
		};
		
		$.ajax({
			type : "POST",
			url : "/getList.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				
			},
			error : function(xhr){
				
			},
			complete : function(){
				
			}
		});
		
	};
	
	var displayResult = function(data){
		
	};
	
	var registerItem = function(){
		
		
		var param = {
				
		};
		
		$.ajax({
			type : "POST",
			url : "/registerItem.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				
			},
			error : function(xhr){
				
			},
			complete : function(){
				
			}
		});
	};
	
};