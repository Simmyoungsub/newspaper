/**
 * 
 */

var common = function(){
	var event = this.event = {
			addEventListener : function(obj,event,callBack){
				obj.off();
				obj.on(event,callBack);
			}
	};
	
	var util = this.util = {
		getDate : function(date){
			
			var yyyy = date.getFullYear(),
				MM = date.getMonth()+1,
				dd = date.getDate();
			
			MM = MM<"10"?"0"+MM : MM;
			dd = dd<"10"?"0"+dd : dd;
			
			return yyyy+"-"+MM+"-"+dd;
			
		},
		getDateTime : function(date){
			
			var hh = date.getHours(),
				mm = date.getMinutes(),
				ss = date.getSeconds();
			
			hh = hh<"10"?"0"+hh : hh;
			mm = mm<"10"?"0"+mm : mm;
			ss = ss<"10"?"0"+ss : ss;
			
			return this.getDate(date)+" "+hh+":"+mm+":"+ss;
			
		},
		getParameterMap : function(){
			var parameterMap = {},
				substr = location.search.substr(1),
				splitstr = substr.split("&");
			
			for(var i=0;i<splitstr.length;i++){
				var pair = splitstr[i].split("=");
				
				parameterMap[pair[0]] = pair[1];
			}
			
			return parameterMap;
		}
	};
};