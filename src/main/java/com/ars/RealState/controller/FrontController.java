package com.ars.RealState.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ars.RealState.service.HomeDetailService;
import com.ars.RealState.service.LandDetailService;
import com.ars.RealState.service.UserService;



@Controller
public class FrontController {
	@Autowired
	HomeDetailService homedetailservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	LandDetailService landdetailservice;
	
	@GetMapping({"/","/Home"})
	public String openHomepage(Model model) {
		model.addAttribute("homedetails", homedetailservice.getAllHomeDetails());
		model.addAttribute("landdetails",landdetailservice.getAllLandDetails());
		model.addAttribute("agent",userservice.getUserByRole("ROLE_AGENT")); 
		return "Home";
	}

	
	
	
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/demo")
	public String demo() {
		return "blank";
	}

	
}
