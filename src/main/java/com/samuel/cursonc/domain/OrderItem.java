package com.samuel.cursonc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Double off;
	private Integer quantity;
	private Double price;
	
	@JsonIgnore
	@EmbeddedId
	private OrderItemPK pk = new OrderItemPK();
	
	public OrderItem() {
		
	}

	public OrderItem(Double off, Integer quantity, Double price, Order order, Product product) {
		super();
		this.off = off;
		this.quantity = quantity;
		this.price = price;
		this.pk.setOrder(order);
		this.pk.setProduct(product);
	}

	public Double getOff() {
		return off;
	}

	public void setOff(Double off) {
		this.off = off;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public OrderItemPK getPk() {
		return pk;
	}

	public void setPk(OrderItemPK pk) {
		this.pk = pk;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return pk.getOrder();
	}
	
	public Product getproduct() {
		return pk.getProduct();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
	
}
