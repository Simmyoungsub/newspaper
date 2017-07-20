package com.spring.board.service.dao;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.spring.board.service.Command;

@Service
public class UserDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<User> getAll(){
		try{
			
			return this.jdbcTemplate.query(Command.GETUSERALL.getCommand(), new BeanPropertyRowMapper<User>(User.class));
			
		}catch(Exception e){
			this.logger.info(e.getMessage());
		}
		
		return null;
	}
	
	public void update(User user){
		SqlParameterSource params = this.setParameter(user);
		this.update(Command.UPDATEUSERINFO.getCommand(), params);
	}
	
	private void update(String query , SqlParameterSource params){
		this.logger.info(query);
		try{
			this.jdbcTemplate.update(query, params);
		}catch(Exception e){
			this.logger.info(e.getMessage());
		}
	}
	
	private SqlParameterSource setParameter(User user){
		try{
			Class<User> clazz = User.class;
			Method[] methods = clazz.getDeclaredMethods();
			MapSqlParameterSource params = new MapSqlParameterSource();

			for(Method m : methods){
				if(m.getName().indexOf("get")>-1){
					params.addValue(m.getName().substring(3, m.getName().length()).toLowerCase(), m.invoke(user, new Object[]{}));
				}
			}
			
			return params;
		}catch(Exception e){
			this.logger.info(e.getMessage());
		}
		
		return null;
	}
	
	public void addUser(User user) {
		
		SqlParameterSource params = this.setParameter(user);
		this.addUser(Command.ADDUSER.getCommand(),params);
		
	}
	
	private void addUser(String query , SqlParameterSource params) {
		try {
			this.jdbcTemplate.update(query, params);
		}catch(Exception e) {
			this.logger.info(e.getMessage());
		}
	}
}
