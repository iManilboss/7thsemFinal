package com.ars.RealState.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ars.RealState.model.UserDetail;
import com.ars.RealState.service.ImageUploadService;
import com.ars.RealState.service.ImageUploadServiceImpl;
import com.ars.RealState.service.MenuUploadService;
import com.ars.RealState.service.UserService;



@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@Autowired
	MenuUploadService menuuploadservice;
	
	
	@GetMapping("/admin/signup")
	public String openRegisterPage() {
		return "Admin/signup";
	}
	
	@GetMapping("/register")
	public String register() {
		return "Register";
	}
	
	@PostMapping("/register")
	public String registerUser(
			
			@RequestParam("email") String email,
			
			
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("authority")String authority)  {
		UserDetail userdetail =new UserDetail();
	
		userdetail.setEmail(email);
		
		userdetail.setUsername(username);
		userdetail.setPassword(password);
		userdetail.setAuthority(authority);
		
		userservice.saveUserDetail(userdetail);
		return "redirect:/login";
	}
	
	/*	@PostMapping("/signup")
	public String registerUser(@ModelAttribute("UserDetail") UserDetail userdetail) {
		
		// call userservice to save user details 
		userservice.saveUserDetail(userdetail);
		return "redirect:/signup";
	}  */
	
	@PostMapping("/signup")
	public String registerUser(@RequestParam("firstName") String fname,
			@RequestParam("lastName") String lname,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("dob")String dob,
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("authority")String authority,
			@RequestParam("photo")MultipartFile photo)  {
		System.out.println(photo.getOriginalFilename());
		if(menuuploadservice.uploadMenuImage(photo)) {
		UserDetail userdetail =new UserDetail();
		userdetail.setFirstName(fname);
		userdetail.setLastName(lname);
		userdetail.setEmail(email);
		userdetail.setPhone(phone);
		userdetail.setUsername(username);
		userdetail.setPassword(password);
		userdetail.setAuthority(authority);
		userdetail.setPhoto(photo.getOriginalFilename());
		
		userservice.saveUserDetail(userdetail);
		return "redirect:/admin/dashboard";
		}else {
			return "redirect:/admin/dashboard?upload_failed";

		}
	}
	
	@GetMapping("/user/profile")
	public ModelAndView openUserHome(ModelAndView mv,Principal principal) {
		mv.addObject("user", principal.getName());
		mv.addObject("userDetails", userservice.getUserDetailByUsername(principal.getName()));
		mv.setViewName("Home");
		return mv;
	}
}
