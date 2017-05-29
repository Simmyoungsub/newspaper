package com.spring.board.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
			
			List userList = (List)(this.boardService.call(Command.GETUSERINFO, reqMap).get("result"));
			
			if(userList.isEmpty()){
				throw new BoardException("존재하지 않는 계정");
			}
			
			Map<String,Object> userInfo = (Map<String, Object>) userList.get(0);
			
			this.logger.info("{}",userInfo);
			
			if(!userInfo.get("userId").equals(userId) || !userInfo.get("userPw").equals(passWd)){
				throw new BoardException("계정을 다시 확인해 주세요.");
			}
			
			resMap.put("result", "success");
			
		}catch(Exception e){
			this.logger.info(e.getMessage());
			throw new BoardException("로그인 프로세스 중 예외발생");
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
}
