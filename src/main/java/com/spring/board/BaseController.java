package com.spring.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/*.page", method=RequestMethod.GET)
	public Model getPage(Model model, HttpServletRequest request){
		
		this.logger.info("request page : " + request.getContextPath()+request.getServletPath());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		model.addAttribute("nowTime",dateFormat.format(new Date()));
		
		return model;
	}
}
