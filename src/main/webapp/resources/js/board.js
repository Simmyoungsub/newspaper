/**
 * 
 */

var board = function(){
	
	common.call(this);
	
	var self = this;
	
	var $registerBtn = $("#registerBtn"),
		$list = $(".list");
	
	this.init = function(){
		retreive();
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
			url : "getList.json",
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
			var tbody = $("<tbody></tbody>");
			
			for(var i=0;i<data.length;i++){
				var tr = $("<tr></tr>"),
					td = $("<td></td>"),
					btn = $("<button></button>"),
					div = $("<div></div>").addClass("detailBtn"),
					a = $("<a></a>"),
					item = data[i];
				
				tr.html(td.clone().html(item["bno"])).append(td.clone().html(a.addClass("detailLink").html(item["title"]).attr({
					"data-bno" : item["bno"],
					"data-boardValue" : item["boardValue"],
					"href" : "#"
				})))
				.append(td.clone().html(item["writer"])).append(td.clone().html(self.util.getDateTime(new Date(item["regDate"]))))
				.append(td.clone().html(div.clone().html(btn.clone().html("삭제"))));
				
				tbody.append(tr);
			}
			$list.append(tbody);
			
			var callBack = function(e){
				e.preventDefault();
				
				var param = {};
				param = $(this).data();
				
				var url = "boardDetail.page?";
				var idx = 0;
				
				for(var key in param){
					url += idx === 0?key+"="+param[key]:"&"+key+"="+param[key];
					idx++;
				}
				
				location.href=url;
			}
			
			self.event.addEventListener($(".detailLink"),"click",callBack);
		}
	};
	
	var getTableHeader = function(){
		var th = $("<th></th>"),
			tr = $("<tr></tr>"),
			thead = $("<thead></thead>");
		
		thead.html(tr.html(th.clone().addClass("bnoHeader").html("번호")).append(th.clone().addClass("titleHeader").html("제목")).append(th.clone().addClass("writerHeader").html("작성자"))
		.append(th.clone().addClass("regDateHeader").html("날짜")).append(th.clone().addClass("detailBtnHeader").html("")));
		
		$list.html(thead);
	};
	
};