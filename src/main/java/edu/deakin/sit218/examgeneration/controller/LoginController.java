package edu.deakin.sit218.examgeneration.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	final static Logger logger = Logger.getLogger(LoginController.class);


	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}
	
	// Add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		logger.warn("User tried to access the restriced resource");
		return "access-denied";
	}
}

