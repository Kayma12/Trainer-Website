package com.shoppingBrowser.trainers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderSheet {

	@Id
	private String OrderId;
	private  String dateOfOrder;
	private String deliveryAddress;
	private String trainerDescription;
	
	
	
	//gettersAndSetters
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getTrainerDescription() {
		return trainerDescription;
	}
	public void setTrainerDescription(String trainerDescription) {
		this.trainerDescription = trainerDescription;
	}
	//toString
	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", dateOfOrder=" + dateOfOrder + ", deliveryAddress=" + deliveryAddress
				+ ", trainerDescription=" + trainerDescription + "]";
	}
	
	
}
