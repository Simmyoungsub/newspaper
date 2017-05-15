package com.spring.board.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UUIDUtil {
	
	public static String getHashValue(byte[] salt, String... target) {
		String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            
            String targetConvert = "";
            
            for(String t : target){
            	targetConvert += t;
            }
            
            byte[] bytes = md.digest(targetConvert.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
}
