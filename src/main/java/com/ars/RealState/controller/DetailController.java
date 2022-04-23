package com.ars.RealState.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ars.RealState.service.HomeDetailService;
import com.ars.RealState.service.LandDetailService;
import com.ars.RealState.service.UserService;

@RequestMapping("/admin")
@Controller
public class DetailController {
	@Autowired
	UserService userservice;
	@Autowired
	HomeDetailService homedetailservice;
	@Autowired
	LandDetailService landdetailservice;
	
	@GetMapping("/a_detail/show")
	public String adminShow(Model model) {
		model.addAttribute("admins_detail",userservice.getAllItems("ROLE_ADMIN"));
		return "Admin/admin_detail";
	}
	@GetMapping("/agent_detail/show")
	public String agentShow(Model model) {
		model.addAttribute("agent_detail",userservice.getAllItems("ROLE_AGENT"));
		return "Admin/agent_detail";
	}
	@GetMapping("/user_detail/show")
	public String userShow(Model model) {
		model.addAttribute("user_detail",userservice.getAllItems("ROLE_USER"));
		return "Admin/user_detail";
	}
	@GetMapping("/a_detail/edit/{id}")
	public String editItem(@PathVariable("id") int id, Model model) {
		model.addAttribute("item",userservice.getUserDetailById(id));
		return "Admin/admin_detail";
		}
	@GetMapping("/a_detail/delete/{id}")
	public String deleteItem(@PathVariable("id") int id) {
	//	userservice.deleteUser(id);
		return "redirect:/a_detail/show";
	}
	@GetMapping("/home_detail/show")
	public String homeShow(Model model) {
		model.addAttribute("home_detail",homedetailservice.getAllHomeDetails());
		return "Admin/home_detail";
	}
	
	@GetMapping("/land_detail/show")
	public String landShow(Model model) {
		model.addAttribute("land_detail",landdetailservice.getAllLandDetails());
		return "Admin/land_detail";
	}
	
	@GetMapping("/home_detail/delete/${id}")
	public String deleteHome(@PathVariable("id") int id,Model model) {
		int homedetails = homedetailservice.deleteHomeById(id);
		model.addAttribute("home_detail",homedetails);

		//	userservice.deleteHome(id);
		return "redirect:/admin/home_detail/show";
}
	
	
	
}