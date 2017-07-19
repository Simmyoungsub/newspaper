package com.spring.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardServiceIn{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * 데이터 조회시 사용
	 */
	@Override
	public Map<String, Object> call(Command command, Map<String, Object> reqMap) {
		Map<String,Object> resMap = new HashMap<String,Object>();
		resMap.put("result",this.call(command.getCommand(), reqMap));
		
		return resMap;
	}
	
	/**
	 * 쿼리 실행
	 */
	@Override
	public Map<String, Object> execute(Command command, Map<String, Object> reqMap) {
		return this.execute(command.getCommand(), reqMap);
	}
	
	private Map<String,Object> execute(String query, Map<String,Object> reqMap){
		Map<String,Object> resMap = new HashMap<String,Object>();
		try{
			this.logger.info(query);
			this.jdbcTemplate.update(query, reqMap);
			resMap.put("result", "success");
		}catch(Exception e){
			this.logger.info(e.getMessage());
			resMap.put("result", "false");
		}
		
		return resMap;
	}
	
	@SuppressWarnings("rawtypes")
	private List call(String query,Map<String,Object> reqMap){
		
		try{
			this.logger.info(query);
			return this.jdbcTemplate.queryForList(query, reqMap);
		}catch(Exception e){
			this.logger.info(e.getMessage());
		}
		
		return null;
	}
}
