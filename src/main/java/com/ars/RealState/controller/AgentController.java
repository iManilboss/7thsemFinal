package com.ars.RealState.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ars.RealState.model.BuyRequest;
import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.LandDetails;
import com.ars.RealState.model.UserDetail;
import com.ars.RealState.service.HomeDetailService;
import com.ars.RealState.service.LandDetailService;
import com.ars.RealState.service.UserService;
import com.ars.RealState.service.homeContactService;


@Controller
public class AgentController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HomeDetailService homeService;
	
	@Autowired
	LandDetailService landService;
	
	@Autowired
	homeContactService homecontactservice;
	
	@GetMapping("agent/agentHome")
	public String getAgentHome() {
		
		return "Agent/AgentHome";
	}

	
	
	
	@GetMapping("/agent/profile")
	public ModelAndView openUserHome(ModelAndView mv,Principal principal) {
		
		mv.addObject("agent", principal.getName());
		//here userdetails is details of an agent 
		UserDetail userdetails =  userService.getUserDetailByUsername(principal.getName());
		mv.addObject("userDetails",userdetails);
		List<HomeDetails> homedetails = homeService.getHomeDetailByAgent(userdetails);
		mv.addObject("homedetails" ,homedetails);
		
		List<LandDetails> landdetails = landService.getHomeDetailByAgent(userdetails);
		mv.addObject("landdetails" ,landdetails);
		
		List<BuyRequest> buyrequest = homecontactservice.getbuyDetailByAgent(userdetails.getId());
		mv.addObject("buyrequest", buyrequest);
		
		mv.setViewName("/Agent/AgentHome");
		
		
		return mv;
	}

}
