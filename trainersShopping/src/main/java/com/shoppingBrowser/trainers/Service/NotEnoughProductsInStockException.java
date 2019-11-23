package com.shoppingBrowser.trainers.Service;

import com.shoppingBrowser.trainers.model.Trainer;

public class NotEnoughProductsInStockException extends Exception {
	
	 private static final String DEFAULT_MESSAGE = "Not enough products in stock";

	    public NotEnoughProductsInStockException() {
	        super(DEFAULT_MESSAGE);
	    }

	    public NotEnoughProductsInStockException(Trainer trainer) {
	        super(String.format("Not enough %s products in stock. Only %d left", trainer.getTrainerDescription(), trainer.getQuantityInStock()));
	    }


}
