package com.spring.board.service;

public enum Command {
	
	GETLIST("getList","select * from newspaper.board"),
	REGISTERITEM("registerItem","insert into newspaper.board (boardValue,title,content,writer,file,regDate) values (:boardValue,:title,:content,:writer,:file,NOW())"),
	UPDATEITEM("updateItem",""),
	DELETEITEM("deleteItem",""),
	GETITEM("getItem","select * from newspaper.board where bno = :bno and boardValue = :boardValue");
	
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
