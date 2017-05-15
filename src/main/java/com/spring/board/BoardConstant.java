package com.spring.board;

public class BoardConstant {
	
	private static String SALT = "board";
	
	public static byte[] getSalt(){
		return BoardConstant.SALT.getBytes();
	}
	
}
