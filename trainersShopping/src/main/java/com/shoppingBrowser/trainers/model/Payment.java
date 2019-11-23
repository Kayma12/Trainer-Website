package com.shoppingBrowser.trainers.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userName")
	private User user;
	@Id
	private BigDecimal cardNumber;
	private double amountOnCard;
	private Date expiryDate;
	private String cardType;
	private double totalAmount;
	private Date paymentDate ;
	
	
	
	
	//gettersAndSetters
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BigDecimal getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(BigDecimal cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getAmountOnCard() {
		return amountOnCard;
	}
	public void setAmountOnCard(double amountOnCard) {
		this.amountOnCard = amountOnCard;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
