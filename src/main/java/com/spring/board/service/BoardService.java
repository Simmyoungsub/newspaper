package com.spring.board.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardServiceIn{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	//조회
	@Override
	public Map<String, Object> call(Command command, Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//수정 
	@Override
	public Map<String, Object> execute(Command command, Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return this.execute(command.getCommand(), reqMap);
	}
	
	public Map<String,Object> execute(String query, Map<String,Object> reqMap){
		Map<String,Object> resMap = new HashMap<String,Object>();
		try{
			this.jdbcTemplate.update(query, reqMap);
			resMap.put("result", "success");
		}catch(Exception e){
			resMap.put("result", "false");
		}
		
		return resMap;
	}

}
