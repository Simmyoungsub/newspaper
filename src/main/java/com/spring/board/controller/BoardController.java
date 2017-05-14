package com.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.board.service.BoardService;
import com.spring.board.service.Command;
import com.spring.board.util.FileUtil;

@Controller
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/getList.json", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getList(@RequestBody Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;
		
		try{
			resMap = this.boardService.call(Command.GETLIST, reqMap);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	@RequestMapping(value="/registerItem.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> registerItem(MultipartHttpServletRequest request) throws RuntimeException{
		Map<String,Object> resMap = null;
		Map<String,Object> reqMap = getParamterMap(request);
		
		try{
			
			resMap = this.boardService.execute(Command.REGISTERITEM, reqMap);
			
			if(reqMap.containsKey("fileName")){
				MultipartFile file = request.getFile("file");
				FileUtil.saveFile(file);
			}
			
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	@RequestMapping(value="/updateItem.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateItem(@RequestBody Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;
		
		try{
			resMap = this.boardService.execute(Command.UPDATEITEM, reqMap);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	@RequestMapping(value="/deleteItem.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteItem(@RequestBody Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;
		
		try{
			resMap = this.boardService.execute(Command.DELETEITEM, reqMap);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	@RequestMapping(value="/uploadFile.json", method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) throws RuntimeException{
		Map<String,Object> resMap = null;
		
		MultipartFile file = request.getFile("file");
		
		FileUtil.saveFile(file);
		
		return "success";
	}
	
	public Map<String,Object> getParamterMap(MultipartHttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("title", request.getParameter("title"));
		map.put("content", request.getParameter("content"));
		
		MultipartFile file = request.getFile("file");
		
		if(!file.isEmpty()){
			map.put("fileName", file.getOriginalFilename());
		}
		
		return map;
	}
}
