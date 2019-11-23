package com.shoppingBrowser.trainers.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingBrowser.trainers.dao.UserRepo;
import com.shoppingBrowser.trainers.model.User;

@Controller
public class UserController {

	
	
	@Autowired
	UserRepo userRepo;

	@RequestMapping("/")
	public String home() {

		return "home.jsp";

	}
	
	

	@RequestMapping("/login")
	public String login(Model model, String message,@RequestParam String userName, @RequestParam String password, HttpSession session, HttpServletRequest request) {
		
		
		User user = userRepo.findByUserName(userName);
		
		boolean userExist = userRepo.existsById(userName);
			
		if(userExist == true && user.getPassword().equals(password)) {
			//session set when logged in
			session = request.getSession();
			session.setAttribute("firstName", user.getFirstName());			
			return "loginSuccess.jsp";
		}
		
		model.addAttribute("message", "Your username or password is invalid.");
		return "login.jsp";
		

	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid User user, Model model, String regMessage,@RequestParam String userName, @RequestParam String password, @RequestParam String confirmPassword, @RequestParam String emailAddress ) {
		
		
		
		boolean userExist = userRepo.existsById(userName);
		
		if(userExist == true) {
			model.addAttribute("regMessage", "User already exist!!!");
			return "register.jsp";
			
		}else if(!password.equals(confirmPassword)) {
			model.addAttribute("regMessage", "please check passwords are the same!!");
			return "register.jsp";
		
		}else if (!emailAddress.contains("@")|| !emailAddress.contains(".")) {
			
			model.addAttribute("regMessage", "Please check email format!!");
			return "register.jsp";
			
		}
		user.setUserName(userName);
		userRepo.save(user);
		
		return "registerSuccess.jsp";
		
		}
		
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage( HttpServletRequest request) {
		request.getSession().invalidate();
	    return "redirect:/home.jsp";
	    
	}

	
	
	
	}


