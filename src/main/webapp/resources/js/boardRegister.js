/**
 * 
 */

var boardRegister = function(){
	
	var $registerBtn = $("#registerBtn");
	
	this.init = function(){
		addEvent();
	};
	
	var addEvent = function(){
		$registerBtn.on("click",function(){
			register();
		});
	};
	
	var register = function(){
		
		var param = {
				
		};
		
		$.ajax({
			type : "POST",
			url : "registerItem.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				console.log(data);
			},
			error : function(xhr){
				console.log(xhr);
			},
			complete : function(){
				
			}
		});
		
	};
	
};