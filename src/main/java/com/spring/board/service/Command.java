package com.spring.board.service;

public enum Command {
	
	GETLIST("getList",""),
	REGISTERITEM("registerItem","insert into board value (:title,:content,:writer,:regDate,:file"),
	UPDATEITEM("updateItem",""),
	DELETEITEM("deleteItem","");
	
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
