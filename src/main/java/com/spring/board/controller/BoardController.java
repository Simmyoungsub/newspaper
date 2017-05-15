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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.board.BoardConstant;
import com.spring.board.service.BoardService;
import com.spring.board.service.Command;
import com.spring.board.util.DateUtil;
import com.spring.board.util.FileUtil;
import com.spring.board.util.UUIDUtil;

@Controller
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/getList.json", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getList(Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;

		try{
			resMap = this.boardService.call(Command.GETLIST, reqMap);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	@RequestMapping(value="/getItem.json", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getItem(@RequestParam Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;

		try{
			this.logger.info(reqMap.toString());
			resMap = this.boardService.call(Command.GETITEM, reqMap);
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
			this.logger.info(reqMap.toString());
			resMap = this.boardService.execute(Command.REGISTERITEM, reqMap);
			
			if(reqMap.containsKey("file")){
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
		
		map.put("title", request.getParameter("title").toString());
		map.put("content", request.getParameter("content").toString());
		map.put("writer", "admin");
		map.put("boardValue", UUIDUtil.getHashValue(BoardConstant.getSalt(),DateUtil.getYYYYMMDD()));
		MultipartFile file = request.getFile("file");
		
		if(!file.isEmpty()){
			map.put("file", file.getOriginalFilename().toString());
		}else{
			map.put("file", null);
		}
		
		return map;
	}
	
//	private Map<String,Object> setListParameter(Map<String,Object>reqMap){
//		if(!reqMap.containsKey("bno")){
//			reqMap.put("bno", "");
//		}
//		
//		if(!reqMap.containsKey("boardValue")){
//			reqMap.put("boardValue", "");
//		}
//		
//		return reqMap;
//	}
}
