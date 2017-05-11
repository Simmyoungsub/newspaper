package com.spring.board.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardServiceIn{
	
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
		Map<String,Object> resMap = new HashMap<String,Object>();
		resMap.put("result", "success");
		return resMap;
	}

}
