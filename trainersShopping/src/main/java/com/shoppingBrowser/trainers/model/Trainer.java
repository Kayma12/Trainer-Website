package com.shoppingBrowser.trainers.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {

	@Id
	private String trainerId  ;
	private BigDecimal priceOfTrainer;
	private String trainerDescription;
	private int quantityInStock;
	
	
	
	//getters and setters
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public BigDecimal getPriceOfTrainer() {
		return priceOfTrainer;
	}
	public void setPriceOfTrainer(BigDecimal priceOfTrainer) {
		this.priceOfTrainer = priceOfTrainer;
	}
	public String getTrainerDescription() {
		return trainerDescription;
	}
	public void setTrainerDescription(String trainerDescription) {
		this.trainerDescription = trainerDescription;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	//tostring
	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", priceOfTrainer=" + priceOfTrainer + ", trainerDescription="
				+ trainerDescription + ", quantityInStock=" + quantityInStock + "]";
	}
	
	
	
	
	


	
}
