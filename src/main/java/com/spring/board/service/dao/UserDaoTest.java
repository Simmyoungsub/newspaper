package com.spring.board.service.dao;

public class UserDaoTest {
	public static void main(String[] args){
		User u1 = new User("user1","123",10,Level.BASIC,0,0);
		User u2 = new User("user2","123",10,Level.SILVER,0,0);
		User u3 = new User("user3","123",10,Level.GOLD,0,0);
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
	}
}
