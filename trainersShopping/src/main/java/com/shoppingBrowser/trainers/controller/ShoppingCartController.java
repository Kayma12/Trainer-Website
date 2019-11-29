package com.shoppingBrowser.trainers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingBrowser.trainers.Service.ShoppingCartService;
import com.shoppingBrowser.trainers.dao.TrainerRepo;

@Controller
public class ShoppingCartController {

	private final ShoppingCartService shoppingCartService;

	TrainerRepo trainerRepo;

	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService, TrainerRepo trainerRepo) {
		this.shoppingCartService = shoppingCartService;
		this.trainerRepo = trainerRepo;
	}

	@GetMapping("/shoppingCart")
	public ModelAndView shoppingCart() {

		ModelAndView modelAndView = new ModelAndView("/shoppingCart.jsp");
		modelAndView.addObject("trainers", shoppingCartService.getProductsInCart());
		modelAndView.addObject("total", shoppingCartService.getTotal().toString());
		//System.out.println(shoppingCartService.getProductsInCart().entrySet());
		return modelAndView;
	}

	@GetMapping("/shoppingCart/addProduct/{trainerId}")
	public ModelAndView addProductToCart(@PathVariable("trainerId") String trainerId) {
		trainerRepo.findByTrainerId(trainerId).ifPresent(shoppingCartService::addProduct);
		return shoppingCart();

	}

}
