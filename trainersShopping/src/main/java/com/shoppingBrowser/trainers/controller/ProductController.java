package com.shoppingBrowser.trainers.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingBrowser.trainers.dao.TrainerRepo;
import com.shoppingBrowser.trainers.dao.UserRepo;
import com.shoppingBrowser.trainers.model.Trainer;


@Controller
public class ProductController {

	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	TrainerRepo trainerRepo;
//	
//	@PostMapping("/trainer")
//	public Trainer addTrainer(@RequestBody Trainer trainer) {
//		//repo.save(trainer);
//		return trainer;
//	}
	@RequestMapping("/products")
	public ModelAndView getProducts() {	
		ModelAndView modelAndView = new ModelAndView("products.jsp");
		List<Trainer> trainers = trainerRepo.findAll();
		modelAndView.addObject("trainers",trainers);
		
		
		return modelAndView;
	}
	


}
