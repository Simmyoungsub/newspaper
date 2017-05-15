package com.spring.board.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.spring.board.exception.BoardException;

public class FileUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static void saveFile(MultipartFile file){
		
		if(!file.isEmpty()){
			try{
				byte[] bytes = file.getBytes();
				
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath+File.separator + "tmpFile");
				
				if(!dir.exists()){
					dir.mkdirs();
				}
				
				File serverFile = new File(dir.getAbsolutePath() + File.separator+file.getOriginalFilename());
				FileUtil.logger.info(dir.getAbsolutePath() + File.separator+file.getOriginalFilename());
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(serverFile));
				
				out.write(bytes);
				out.close();
				
				FileUtil.logger.info("Server File Location = " + serverFile.getAbsolutePath());
			}catch(Exception e){
				throw new BoardException("파일 저장 실패");
			}
		}else{
			FileUtil.logger.info("file is empty");
		}
	}
}
