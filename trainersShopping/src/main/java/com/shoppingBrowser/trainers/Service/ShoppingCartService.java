package com.shoppingBrowser.trainers.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import com.shoppingBrowser.trainers.model.Trainer;

public interface ShoppingCartService {
	
    void addProduct(Trainer item);

    void removeProduct(Trainer trainer);

    Map<Trainer, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

}
