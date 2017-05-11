package com.spring.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.service.BoardService;
import com.spring.board.service.Command;

@Controller
public class BoardController {
	
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
	public Map<String,Object> registerItem(@RequestBody Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;
		
		try{
			resMap = this.boardService.execute(Command.REGISTERITEM, reqMap);
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
}
