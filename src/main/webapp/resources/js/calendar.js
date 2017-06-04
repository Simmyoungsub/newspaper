/**
 * 
 */
var calendar = function(){
	
	common.call(this);
	var self = this;
	
	var $result = $(".result"),
		$ymd = $(".yyyy-mm-dd"),
		$prev = $(".prev"),
		$next = $(".next");
	
	var calendarForm = {},
		currentForm = {};
	
	this.init = function(){
		initCalendarForm();
		displayResult();
		addEvent();
	};
	
	var addEvent = function(){
		
		$prev.on("click",function(e){
			 e.preventDefault();
			 var month = parseInt(calendarForm["month"]),
			 	 prev = month -1;
			 
			 if(prev < 1){
				 var yyyy = parseInt(calendarForm["year"]);
				 calendarForm["year"] = "" + (yyyy-1);
				 month = 12;
			 }else{
				 month = prev;
			 }
			 
			 calendarForm["month"] = month<10?"0"+month : "" + month;
			 
			 displayResult();
		});
		
		$next.on("click",function(e){
			e.preventDefault();
			var month = parseInt(calendarForm["month"]),
		 	 	next = month +1;
		 
			 if(next > 12){
				 var yyyy = parseInt(calendarForm["year"]);
				 calendarForm["year"] = "" + (yyyy+1);
				 month = 1;
			 }else{
				 month = next;
			 }
			 
			 calendarForm["month"] = month<10?"0"+month : "" + month;
			 
			 displayResult();
		});
		
	};
	
	var displayResult = function(){
		
		getHeader();
		var first = new Date(getCalendarString(calendarForm));
		first.setDate(1);
		var day = first.getDay();
		var one_date = 7;
		var tr = $("<tr></tr>"),
			tbody = $("<tbody></tbody>");
		var calendar = [];
		var week = [];
		var start = 1;
		
		for(var i=0;i<one_date;i++){
			var td = $("<td></td>");
			
			if(i>=day){
				td.html(start++);
			}else{
				td.html("");
			}
			
			tr.append(td);
			tbody.append(tr);
		}
		$result.append(tbody);
		
		first.setMonth(first.getMonth()+1);
		first.setDate(0);
		
		var weeks = parseInt((first.getDate()-(start-1))/one_date);
		var etc = parseInt((first.getDate()-(start-1))%one_date);
		
		for(var i=0;i<weeks;i++){
			var tr = $("<tr></tr>");
			
			for(var j=0;j<one_date;j++){
				var td = $("<td></td>");
				
				tr.append(td.html(start++));
			}
			tbody.append(tr);
			$result.append(tbody);
		}
		
		if(etc !== 0){
			tr = $("<tr></tr>");
			for(var i=0;i<etc;i++){
				var td = $("<td></td>");
				tr.append(td.clone().html(start++));
			}
			tbody.append(tr);
			$result.append(tbody);
		}
		
		var callBack = function(){
			//calendarForm["date"] = $(this).text();
			currentForm["year"] = calendarForm["year"];
			currentForm["month"] = calendarForm["month"];
			currentForm["date"] = ($(this).text()<10? "0" + $(this).text() : $(this).text());
			$ymd.html(getCalendarString(currentForm));
		};
		
		self.event.addEventListener($("tbody td"),"click",callBack);
	};
	
	var getHeader = function(){
		
		var th = $("<th></th>"),
			td = $("<td></td>");
		
		th.html(td.clone().html("일")).append(td.clone().html("월")).append(td.clone().html("화")).append(td.clone().html("수")).append(td.clone().html("목")).append(td.clone().html("금")).append(td.clone().html("토"));
		$result.html(th);
	};
	
	var initCalendarForm = function(){
		var today = new Date();
		
		calendarForm["year"] = today.getFullYear();
		calendarForm["month"] = (today.getMonth()+1)<10?"0"+(today.getMonth()+1) : (today.getMonth()+1);
		calendarForm["date"] = today.getDate()<10?"0"+today.getDate():today.getDate();
		
	};
	
	var getCalendarString = function(calendarForm){
		
		return calendarForm["year"]+"-"+calendarForm["month"]+"-"+calendarForm["date"];
		
	};
};