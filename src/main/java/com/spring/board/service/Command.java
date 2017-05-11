package com.spring.board.service;

public enum Command {
	
	GETLIST("getList",""),
	REGISTERITEM("registerItem",""),
	UPDATEITEM("registerItem",""),
	DELETEITEM("registerItem","");
	
	private Command(String key, String command){
		this.key = key;
		this.command = command;
	}
	
	private String key;
	private String command;
	
	public String getKey() {
		return key;
	}
	public String getCommand() {
		return command;
	}
}
