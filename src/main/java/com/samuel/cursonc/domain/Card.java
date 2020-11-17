package com.samuel.cursonc.domain;

import javax.persistence.Entity;

import com.samuel.cursonc.domain.enums.PaymentState;

@Entity
public class Card extends Payment{
	
	private static final long serialVersionUID = 1L;
	private Integer split;
	
	public Card() {
		
	}

	public Card(Integer id, PaymentState state, Order order, Integer split) {
		super(id, state, order);
		// TODO Auto-generated constructor stub
		this.split = split;
	}

	public Integer getSplit() {
		return split;
	}

	public void setSplit(Integer split) {
		this.split = split;
	}
	
	
}
