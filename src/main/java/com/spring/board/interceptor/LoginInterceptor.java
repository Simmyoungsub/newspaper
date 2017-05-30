package com.spring.board.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.board.exception.BoardException;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		try{
			HttpSession session = request.getSession();
			Map<String,Object> userInfo = (Map<String, Object>)session.getAttribute("user");
			
			if(userInfo == null){
				throw new BoardException("세션 없음");
			}
			
			this.logger.info("{}",userInfo);
			
		}catch(Exception e){
			this.logger.info(e.getMessage());
			this.logger.info("로그인 페이지로 강제 전이");
			response.sendRedirect("/board/login.page");
		}
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
