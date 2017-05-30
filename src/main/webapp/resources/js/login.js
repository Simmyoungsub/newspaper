/**
 * 
 */

var board_login = function(){
	
	common.call(this);
	
	var self = this;
	
	var $loginBtn = $("#loginBtn"),
		$userId = $("#userId"),
		$userPassword = $("#userPassword");
	
	
	this.init = function(){
		addEvent();
	};
	
	var addEvent = function(){
		$loginBtn.on("click",function(e){
			e.preventDefault();
			login();
		})
	};
	
	var login = function(){
		
		var param = {
			"userId" : $userId.val(),
			"userPw" : encodeURI($userPassword.val())
		};
		
		$.ajax({
			type : "POST",
			url : "login.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
			success : function(data){
				console.log(data);
				location.href="board.page";
			},
			error : function(xhr){
				console.log(xhr);
			},
			complete : function(){
				
			}
		});
	};
	
	var validate = function(){
		
	};
};