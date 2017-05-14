/**
 * 
 */

var board = function(){
	
	common.call(this);
	
	var self = this;
	
	var $registerBtn = $("#registerBtn"),
		$list = $(".list");
	
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
			type : "GET",
			url : "/getList.json",
			data : JSON.stringify(param),
			contentType : "application/json",
			dataType : "json",
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
		getTableHeader();
		
		if(data === null || data.length === undefined){
			
		}else{
			
			for(var i=0;i<data.length;i++){
				var tr = $("<tr></tr>"),
					td = $("<td></td>"),
					btn = $("<button></button>"),
					div = $("<div></div>"),
					item = data[i];
				
				tr.html(td.clone().html(item["bno"])).append(td.clone.html(item["title"])).append(td.clone.html(item["writer"])).append(self.util.getDateTime(new Date(item["regDate"])))
				.append(td.clone.html(div.clone().html(btn.clone().html("보기"))).append(div.clone().html(btn.clone().html("수정"))).append(div.clone().html(btn.clone().html("삭제"))));
				
				$list.append(tr);
			}
			
			
		}
	};
	
	var getTableHeader = function(){
		var th = $("<th></th>"),
			tr = $("<tr></tr>");
		
		tr.html(th.clone().html("번호")).append(th.clone().html("제목")).append(th.clone().html("작성자")).append(th.clone().html("날짜")).append(th.clone().html(""));
		
		$list.html(tr);
	};
	
};