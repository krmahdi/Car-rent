package com.epam.carrental.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Order {
private long orderId;
private long userId;
private long carId;
private Date orderDate;
private Date returnDate;
private boolean carReturned;
private BigDecimal rentalCost;
public Order() {
	super();
}
public Order(long userId, long carId, Date orderDate, Date returnDate, boolean carReturned, BigDecimal rentalCost) {
	super();
	this.userId = userId;
	this.carId = carId;
	this.orderDate = orderDate;
	this.returnDate = returnDate;
	this.carReturned = carReturned;
	this.rentalCost = rentalCost;
}
public Order(long orderId, long userId, long carId, Date orderDate, Date returnDate, boolean carReturned,
		BigDecimal rentalCost) {
	super();
	this.orderId = orderId;
	this.userId = userId;
	this.carId = carId;
	this.orderDate = orderDate;
	this.returnDate = returnDate;
	this.carReturned = carReturned;
	this.rentalCost = rentalCost;
}
@Override
public String toString() {
	return "order [orderId=" + orderId + ", userId=" + userId + ", carId=" + carId + ", orderDate=" + orderDate
			+ ", returnDate=" + returnDate + ", carReturned=" + carReturned + ", rentalCost=" + rentalCost + "]";
}
public long getOrderId() {
	return orderId;
}
public void setOrderId(long orderId) {
	this.orderId = orderId;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public long getCarId() {
	return carId;
}
public void setCarId(long carId) {
	this.carId = carId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Date getReturnDate() {
	return returnDate;
}
public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
}
public boolean isCarReturned() {
	return carReturned;
}
public void setCarReturned(boolean carReturned) {
	this.carReturned = carReturned;
}
public BigDecimal getRentalCost() {
	return rentalCost;
}
public void setRentalCost(BigDecimal rentalCost) {
	this.rentalCost = rentalCost;
}
@Override
public int hashCode() {
	return Objects.hash(carId, carReturned, orderDate, orderId, rentalCost, returnDate, userId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order other = (Order) obj;
	return carId == other.carId && carReturned == other.carReturned && Objects.equals(orderDate, other.orderDate)
			&& orderId == other.orderId && Objects.equals(rentalCost, other.rentalCost)
			&& Objects.equals(returnDate, other.returnDate) && userId == other.userId;
}

}
