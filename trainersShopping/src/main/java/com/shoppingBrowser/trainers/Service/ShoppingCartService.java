package com.shoppingBrowser.trainers.Service;

import java.math.BigDecimal;
import java.util.Map;

import com.shoppingBrowser.trainers.model.Trainer;

public interface ShoppingCartService {
	
    void addProduct(Trainer trainer);

    void removeProduct(Trainer trainer);

    Map<Trainer, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

}
