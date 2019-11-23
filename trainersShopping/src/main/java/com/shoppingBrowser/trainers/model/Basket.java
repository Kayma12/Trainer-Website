package com.shoppingBrowser.trainers.model;

import java.util.HashMap;
import java.util.Map;

public class Basket {

	private User user;

	private Map<Trainer, Integer> itemsInBasket = new HashMap<Trainer, Integer>();

	public Basket() {
		super();
		this.itemsInBasket = null;
	}

	// get user function
	public User getUser() {
		return user;
	}

	// add item to basket
	public void addtItemToBasket(Trainer trainer) {
		Integer amount = itemsInBasket.get(trainer);

		if (amount == null) {
			itemsInBasket.put(trainer, 1);

		} else {

			itemsInBasket.put(trainer, amount + 1);

		}
		
		

	}
}
