package com.shoppingBrowser.trainers.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.ScopedProxyMode;
import com.shoppingBrowser.trainers.dao.TrainerRepo;
import com.shoppingBrowser.trainers.model.Trainer;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
    private final TrainerRepo trainerRepo;

    private Map<Trainer, Integer> trainers = new HashMap<>();

    @Autowired
    public ShoppingCartServiceImpl(TrainerRepo trainerRepo) {
        this.trainerRepo = trainerRepo;
    }

  
    @Override
    public void addProduct(Trainer trainer) {
        if (trainers.containsKey(trainer)) {
            trainers.replace(trainer, trainers.get(trainer) + 1);
        } else {
            trainers.put(trainer, 1);
            
        }
    }

    /**
     * If trainer is in the map with quantity > 1, just decrement quantity by 1.
     * If trainer is in the map with quantity 1, remove it from map
     *
     * @param trainer
     */
    @Override
    public void removeProduct(Trainer trainer) {
        if (trainers.containsKey(trainer)) {
            if (trainers.get(trainer) > 1)
                trainers.replace(trainer, trainers.get(trainer) - 1);
            else if (trainers.get(trainer) == 1) {
                trainers.remove(trainer);
            }
        }
    }

   
    @Override
    public Map<Trainer, Integer> getProductsInCart() {
        return (trainers);
    }

    /**
     * Checkout will rollback if there is not enough of same trainer in stock
     *
     * @throws NotEnoughProductsInStockException
     */
    @Override
    public void checkout() throws NotEnoughProductsInStockException {
        Trainer trainer;
        Optional<Trainer> trainopt;
        for (Map.Entry<Trainer, Integer> entry : trainers.entrySet()) {
            // Refresh quantity for every trainer before checking
        	
        	
            trainopt = trainerRepo.findById((entry.getKey().getTrainerId()));
            trainer = trainopt.get();
            if (trainer.getQuantityInStock() < entry.getValue())
                throw new NotEnoughProductsInStockException(trainer);
            entry.getKey().setQuantityInStock(trainer.getQuantityInStock() - entry.getValue());
        }
        trainerRepo.saveAll(trainers.keySet());
        trainerRepo.flush();
        trainers.clear();
    }

    @Override
    public BigDecimal getTotal() {
        return  trainers.entrySet().stream().map(entry -> entry.getKey().getPriceOfTrainer().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
