package com.spring.board.util;

import java.util.Calendar;

public class DateUtil {
	
	public static Calendar today = Calendar.getInstance();
	
	/**
	 * YYYYMMDD 형태로 출력
	 * @return
	 */
	public static String getYYYYMMDD(){
		Calendar today = DateUtil.today;
		
		int m = today.get(Calendar.MONTH)+1;
		int d = today.get(Calendar.DATE);
		
		String yyyy = ""+today.get(Calendar.YEAR);
		String mm = m<10?"0"+m:""+m;
		String dd = d<10?"0"+d:""+d;
		
		return yyyy+mm+dd;
	}
	
	public static String getYYYYMMDDHHMISS(){
		Calendar today = DateUtil.today;
		
		int m = today.get(Calendar.MONTH)+1;
		int d = today.get(Calendar.DATE);
		int h = today.get(Calendar.HOUR);
		int i = today.get(Calendar.MINUTE);
		int s = today.get(Calendar.SECOND);
		
		String yyyy = ""+today.get(Calendar.YEAR);
		String mm = m<10?"0"+m:""+m;
		String dd = d<10?"0"+d:""+d;
		String hh = h<10?"0"+h:""+h;
		String mi = i<10?"0"+i:""+i;
		String ss = s<10?"0"+s:""+s;
		
		return yyyy+mm+dd+" "+hh+":"+mi+":"+ss;
	}
}
