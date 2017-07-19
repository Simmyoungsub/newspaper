package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.spring.board.service.LoginService;
import com.spring.board.service.UserService;
import com.spring.board.service.dao.User;
import com.spring.board.util.DateUtil;
import com.spring.board.util.FileUtil;
import com.spring.board.util.UUIDUtil;

@Controller
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

	/**
	 * 게시판 목록 출력
	 * @param reqMap
	 * @return
	 * @throws RuntimeException
	 */
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
	
	/**
	 * 게시판 목록 출력
	 * @param reqMap
	 * @return
	 * @throws RuntimeException
	 */
	@RequestMapping(value="/getUserAll.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUserAll(@RequestBody Map<String,Object>reqMap) throws RuntimeException{
		Map<String,Object> resMap = null;

		try{
			List<User> users = this.userService.getUserAll();
			resMap = new HashMap<>();
			
			this.userService.update(users.get(0));
			
			resMap.put("result", users);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	/**
	 * 게시판 상세화면 데이터 출력
	 * @param reqMap
	 * @return
	 * @throws RuntimeException
	 */
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
	
	/**
	 * 게시판 항목 등록
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
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
	
	/**
	 * 게시판 항목 수정
	 * @param reqMap
	 * @return
	 * @throws RuntimeException
	 */
	@RequestMapping(value="/updateItem.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateItem(MultipartHttpServletRequest request) throws RuntimeException{
		Map<String,Object> resMap = null;
		Map<String,Object> reqMap = getUpdateParamterMap(request);
		
		try{
			this.logger.info("{}",reqMap.toString());
			this.logger.info(reqMap.toString());
			resMap = this.boardService.execute(Command.UPDATEITEM, reqMap);
			
			if(reqMap.containsKey("file")){
				MultipartFile file = request.getFile("file");
				FileUtil.saveFile(file);
			}
			
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
	}
	
	/**
	 * 게시판 항목 삭제
	 * @param reqMap
	 * @return
	 * @throws RuntimeException
	 */
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
	
	/**
	 * 첨부파일 다운로드
	 * @param fileName
	 * @param response
	 * @throws RuntimeException
	 */
	@RequestMapping(value="/downloadFile.json", method=RequestMethod.GET)
	public void downloadFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws RuntimeException{
		this.logger.info("fileName : "+fileName);
		
		try{
			FileUtil.fileDownload(response, fileName);
		}catch(Exception e){
			this.logger.info(e.getMessage());
		}
		
	}
	
	@RequestMapping(value="/getReplyList.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getReplyList(@RequestBody Map<String,Object> reqMap) throws RuntimeException{

		Map<String,Object> resMap = null;
		
		try{
			this.logger.info(reqMap.toString());
			resMap = this.boardService.call(Command.GETREPLYLIST, reqMap);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
		
	}
	
	@RequestMapping(value="/registerReply.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> registerReply(@RequestBody Map<String,Object> reqMap) throws RuntimeException{

		Map<String,Object> resMap = null;
		
		
		
		try{
			
			reqMap = this.getRegisterReplyParameter(reqMap);
			
			this.logger.info(reqMap.toString());
			resMap = this.boardService.execute(Command.REGISTERREPLY, reqMap);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return resMap;
		
	}
	
	@RequestMapping(value="/login.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request,@RequestBody Map<String,Object> reqMap) throws RuntimeException{

		Map<String,Object> resMap = null;
		
		try{
			
			this.logger.info(reqMap.toString());
			resMap = this.loginService.login(request,reqMap);
			this.logger.info(resMap.toString());
		}catch(Exception e){
			this.logger.info(e.getMessage());
			resMap = new HashMap<String,Object>();
			resMap.put("result", false);
			resMap.put("msg", e.getMessage());
		}
		
		return resMap;
		
	}
	
	@RequestMapping(value="/logout.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> logout(HttpServletRequest request,@RequestBody Map<String,Object> reqMap) throws RuntimeException{

		Map<String,Object> resMap = null;
		
		this.logger.info(reqMap.toString());
		resMap = this.loginService.logout(request,reqMap);
		this.logger.info(resMap.toString());
		
		return resMap;
		
	}
	
	/**
	 * 게시판 항목 등록 파라미터 변환
	 * @param request
	 * @return
	 */
	public Map<String,Object> getParamterMap(MultipartHttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		
		for(Object key : request.getParameterMap().keySet()){
			map.put(key.toString(), request.getParameter(key.toString()).toString());
		}
		map.put("writer", "admin");
		map.put("boardValue", UUIDUtil.getHashValue(BoardConstant.getSalt(),DateUtil.getYYYYMMDDHHMISS()));
		MultipartFile file = request.getFile("file");
		
		//파일 존재 유무
		if(!file.isEmpty()){
			map.put("file", file.getOriginalFilename().toString());
		}else{
			map.put("file", null);
		}
		
		return map;
	}
	
	/**
	 * 게시판 항목 수정 파라미터 변환
	 * @param request
	 * @return
	 */
	public Map<String,Object> getUpdateParamterMap(MultipartHttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		
		for(Object key : request.getParameterMap().keySet()){
			map.put(key.toString(), request.getParameter(key.toString()).toString());
		}
		
		//map.put("title", request.getParameter("title").toString());
		//map.put("content", request.getParameter("content").toString());
		map.put("writer", "admin");
		//map.put("bno", request.getParameter("bno").toString());
		//map.put("boardValue", UUIDUtil.getHashValue(BoardConstant.getSalt(),DateUtil.getYYYYMMDDHHMISS()));
		MultipartFile file = request.getFile("file");
		
		//파일 존재 유무
		if(!file.isEmpty()){
			map.put("file", file.getOriginalFilename().toString());
		}else{
			map.put("file", null);
		}
		
		return map;
	}
	
	public Map<String,Object> getRegisterReplyParameter(Map<String,Object> reqMap){
		Map<String,Object> map = null;
		
		map = reqMap;
		
		map.put("replyWriter", "admin");
		map.put("replyValue", UUIDUtil.getHashValue(BoardConstant.getSalt(),DateUtil.getYYYYMMDDHHMISS()));
		
		
		return map;
	}
	
}
