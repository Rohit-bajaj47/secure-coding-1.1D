package edu.deakin.sit218.examgeneration.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	final static Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping("/")
	public String showHome() {
		
		logger.warn("User Logged into the system");

		return "home";
	}
}
