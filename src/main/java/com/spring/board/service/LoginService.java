package com.spring.board.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.BoardConstant;
import com.spring.board.exception.BoardException;
import com.spring.board.util.UUIDUtil;

@Service
public class LoginService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	public Map<String,Object> login(HttpServletRequest request, Map<String,Object> reqMap){
		Map<String,Object> resMap = new HashMap<String,Object>();
		
		try{
			
			String userId = reqMap.get("userId").toString();
			String passWd = this.getHashMsg(userId,URLDecoder.decode(reqMap.get("userPw").toString(),"UTF-8"));
			
			reqMap.put("userPw", passWd);
			
			this.logger.info("{}",reqMap);
			
			Map<String,Object> userInfo = this.isUser(reqMap, userId, passWd);
			
			//확인된 userInfo를 쿠키와 세션에 넣고 interceptor 구현
			HttpSession session = request.getSession();
			session.setAttribute("user", userInfo);
			
			resMap.put("result", true);
			
		}catch(Exception e){
			this.logger.info(e.getMessage());
			throw new BoardException("로그인 프로세스 중 예외발생");
		}
		
		return resMap;
	}
	
	public Map<String,Object> logout(HttpServletRequest request, Map<String,Object> reqMap){
		Map<String,Object> resMap = new HashMap<String,Object>();
		
		try{
			HttpSession session = request.getSession();
			Map<String,Object> userInfo = (Map<String,Object>)session.getAttribute("user");
			
			if(userInfo == null){
				throw new BoardException("세션 정보 없음");
			}
			
			this.logger.info("{}",userInfo);
			
			session.removeAttribute("user");
			
			this.logger.info("user 세션 삭제됨");
			
			resMap.put("result", true);
		}catch(Exception e){
			this.logger.info(e.getMessage());
			resMap.put("result", false);
		}
		
		return resMap;
	}
	
	private String getHashMsg(String id, String pw){
		
		this.logger.info("userId = " + id +", userPw = " + pw);
		
		String msg = "";
		
		msg = UUIDUtil.getHashValue(BoardConstant.getSalt(), id,pw);
		this.logger.info("생성된 hashMsg = " + msg);
		return msg;
	}
	
	private Map<String,Object> isUser(Map<String,Object> reqMap, String userId, String passWd) throws BoardException{
		
		List userList = (List)(this.boardService.call(Command.GETUSERINFO, reqMap).get("result"));
		
		if(userList.isEmpty()){
			throw new BoardException("존재하지 않는 계정입니다.");
		}
		
		Map<String,Object> user = (Map<String, Object>) userList.get(0);
		
		this.logger.info("{}",user);
		
		if(!user.get("userId").equals(userId) || !user.get("userPw").equals(passWd)){
			throw new BoardException("계정을 다시 확인해 주세요.");
		}
		
		user.remove("userPw");
		
		return user;
	}
}
