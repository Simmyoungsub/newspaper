package com.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.service.dao.Level;
import com.spring.board.service.dao.User;
import com.spring.board.service.dao.UserDao;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserDao userDao;
	
	public void upgradeLevels(){
		List<User> users = this.getUserAll();
		
		for(User u : users){
			Boolean changed = null;
			
			if(u.getLevel() == Level.BASIC && u.getLogin()>=50){
				
			}else if(u.getLevel() == Level.SILVER && u.getRecommand()>=30){
				
			}else if(u.getLevel() == Level.GOLD ){
				changed = false;
			}else{
				changed = false;
			}
			
			if(changed){
				//userDao.update(u);
				this.logger.info("등급 변경");
			}
		}
	}
	
	public List<User> getUserAll(){
		return userDao.getAll();
	}
	
	public void update(User user){
		this.userDao.update(user);
	}
}
