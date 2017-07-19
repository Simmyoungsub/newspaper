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
			if(canUpgradeLevel(u)){
				upgradeLevel(u);
			}
		}
	}
	
	public List<User> getUserAll(){
		return userDao.getAll();
	}
	
	public void update(User user){
		this.userDao.update(user);
	}
	
	private boolean canUpgradeLevel(User user){
		Level currentLevel = user.getLevel();
		
		switch(currentLevel){
		case BASIC:
			return (user.getLogin()>=50);
		case SILVER:
			return (user.getRecommand()>=30);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level : " + currentLevel);
		}
	}
	
	private void upgradeLevel(User user){
		user.upgradeLevel(user);
		this.userDao.update(user);
	}
}
