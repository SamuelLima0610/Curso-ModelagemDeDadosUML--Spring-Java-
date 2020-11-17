package com.samuel.cursonc.domain.enums;

public enum PaymentState {
	
	PENDENTE(1,"Pendente"),
	QUITATO(2, "Quitato"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private PaymentState(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static PaymentState toEnum(Integer cod) {
		if(cod ==null) return null;
		for(PaymentState x : PaymentState.values()){
			if(cod.equals(x.getCod())) return x;
		}
		throw new IllegalArgumentException("Enum doesn't exist");
	}
}
