/**
 * 
 */

var common = function(){
	var event = this.event = {
			
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
			
			return this.getDate()+" "+hh+":"+mm+":"+ss;
			
		}
		
	};
};