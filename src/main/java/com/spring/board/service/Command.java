package com.spring.board.service;

public enum Command {
	
	GETLIST("getList","SELECT * FROM newspaper.board order by regDate desc"),
	REGISTERITEM("registerItem","insert into newspaper.board (boardValue,title,content,writer,file) values (:boardValue,:title,:content,:writer,:file)"),
	UPDATEITEM("updateItem","update newspaper.board set title = :title , content = :content , writer = :writer , file = :file where bno = :bno and boardValue = :boardValue"),
	DELETEITEM("deleteItem","delete from newspaper.board where bno = :bno and boardValue = :boardValue"),
	GETITEM("getItem","select * from newspaper.board where bno = :bno and boardValue = :boardValue"),
	GETREPLYLIST("getReplyList","select * from newspaper.reply where boardValue = :boardValue"),
	REGISTERREPLY("registerReply","insert into newspaper.reply (replyValue,boardValue,replyContent,replyWriter) values (:replyValue,:boardValue,:replyContent,:replyWriter)"),
	GETUSERINFO("getUserInfo","select * from newspaper.user where userId = :userId and userPw = :userPw"),
	GETUSERALL("getUserAll","select userId, userPwd, userAge, level, login, recommand from newspaper.user"),
	UPDATEUSERINFO("updateUserInfo","update newspaper.user set userPwd=:userpwd , userAge=:userage, level=:level,recommand=:recommand where userId=:userid");
	
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
