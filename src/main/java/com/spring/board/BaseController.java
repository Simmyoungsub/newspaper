package com.spring.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	@RequestMapping(value="/*.page", method=RequestMethod.GET)
	public Model getPage(Model model){
		return model;
	}
}
