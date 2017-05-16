package com.spring.board.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.spring.board.exception.BoardException;

public class FileUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 파일 저장
	 * @param file
	 */
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
	
	/**
	 * 저장된 파일 가져오기
	 * @param fileName
	 * @return
	 */
	public static File getFile(String fileName){
		String rootPath = System.getProperty("catalina.home");
		String fullPath = rootPath+File.separator + "tmpFile"+File.separator +fileName;
		
		File file = new File(fullPath);
		
		return file;
	}
	
	public static byte[] getFileBytes(File file){
		try{
			byte fileBytes[] = FileUtils.readFileToByteArray(file);
			return fileBytes;
		}catch(Exception e){
			FileUtil.logger.info(e.getMessage());
		}
		
		return null;
	}
	
	public static void fileDownload(HttpServletResponse response, String fileName){
		File file = FileUtil.getFile(fileName);
		FileUtil.logger.info("Parameter : {fileName : " + file.toString() + "}");
		byte[] fileBytes = FileUtil.getFileBytes(file);
		FileUtil.responseSetting(response, fileName, fileBytes);
	}
	
	public static void responseSetting(HttpServletResponse response, String fileName,byte[] fileBytes){
		try{
			String encodeFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
			
			
			//첨부파일을 다운 받을 수 있게 response Header 설정
			response.setContentType("application/octet-stream");
		    response.setContentLength(fileBytes.length);
		    response.setHeader("Content-Disposition", "attachment; fileName=\"" + encodeFileName+"\"");
		    response.setHeader("Content-Transfer-Encoding", "binary");
		    response.getOutputStream().write(fileBytes);
		     
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		    
		    FileUtil.logger.info("downloaded file : " + encodeFileName);
		    FileUtil.logger.info("downloaded file : " + fileName);
		}catch(Exception e){
			FileUtil.logger.info(e.getMessage());
		}
	}
}
