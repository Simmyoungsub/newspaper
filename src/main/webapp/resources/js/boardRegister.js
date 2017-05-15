/**
 * 
 */

var boardRegister = function(){
	
	var $registerBtn = $("#registerBtn"),
		$registerForm = $(".registerForm"),
		$title = $("#title"),
		$content = $("#content"),
		$file = $("#file");
	
	this.init = function(){
		addEvent();
	};
	
	var addEvent = function(){
		$registerBtn.on("click",function(){
			register();
		});
		
//		$registerForm.on("submit",function(){
//			var formData = new FormData($(this)[0]);
//			
//			for(var [key, value] of formData.entries()){
//				console.log(key, value);
//			}
//			console.log(formData);
//		});
	};
	
	var register = function(){
		
		var param = {
				
		};
		
		var formData = new FormData($registerForm[0]);
		
		$.ajax({
			type : "POST",
			url : "registerItem.json",
			data : formData,
			processData : false,
			contentType : false,
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
	
//	var uploadFile = function(){
//		
//		var param = {
//				
//		}
//		
//		var formData = new FormData($registerForm[0]);
//		
//		$.ajax({
//			type : "POST",
//			url : "uploadFile.json",
//			data : formData,
//			processData: false,
//		    contentType: false,
//			dataType : "text",
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
//		
//	};
	
};