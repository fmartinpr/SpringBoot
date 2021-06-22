package com.fmartin.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
public class AngularController {
	
	@RequestMapping({"/","/login"})
	public String index() {
		return "forward:/index.html";
	}

}
