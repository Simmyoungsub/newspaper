package com.spring.board.service.dao;

public class User {
	private String userId;
	private String userPwd;
	private int userAge;
	private Level level;
	int login;
	int recommand;
	
	public User(){}
	
	public User(String userId, String userPwd, int userAge, Level level, int login, int recommand){
		this.userId = userId;
		this.userPwd = userPwd;
		this.userAge = userAge;
		this.level = level;
		this.login = login;
		this.recommand = recommand;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public int getRecommand() {
		return recommand;
	}
	public void setRecommand(int recommand) {
		this.recommand = recommand;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userAge=" + userAge + ", level=" + level
				+ ", login=" + login + ", recommand=" + recommand + "]";
	}
}
