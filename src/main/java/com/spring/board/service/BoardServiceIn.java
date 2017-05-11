package com.spring.board.service;

import java.util.Map;

public interface BoardServiceIn {
	public Map<String,Object> call(Command command, Map<String,Object> reqMap);
	public Map<String,Object> execute(Command command, Map<String,Object> reqMap);
}
