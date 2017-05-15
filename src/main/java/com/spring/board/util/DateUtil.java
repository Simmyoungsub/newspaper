package com.spring.board.util;

import java.util.Calendar;

public class DateUtil {
	
	public static Calendar today = Calendar.getInstance();
	
	public static String getYYYYMMDD(){
		Calendar today = DateUtil.today;
		
		int m = today.get(Calendar.MONTH)+1;
		int d = today.get(Calendar.DATE);
		
		String yyyy = ""+today.get(Calendar.YEAR);
		String mm = m<10?"0"+m:""+m;
		String dd = d<10?"0"+d:""+d;
		
		return yyyy+mm+dd;
	}
	
}
