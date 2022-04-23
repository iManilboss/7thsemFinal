package com.ars.RealState.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
	@GetMapping("/dashboard")
	public String dashboard(Authentication auth,Model model) {
		model.addAttribute("user",auth.getName());
		model.addAttribute("role", auth.getAuthorities());
		return "Admin/admin-dashboard";
	}
}
