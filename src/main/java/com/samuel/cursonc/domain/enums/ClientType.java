package com.samuel.cursonc.domain.enums;

public enum ClientType {
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pesso Juridica");
	
	private int cod;
	private String descricao;
	
	private ClientType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static ClientType toEnum(Integer cod) {
		if(cod ==null) return null;
		for(ClientType x : ClientType.values()){
			if(cod.equals(x.getCod())) return x;
		}
		throw new IllegalArgumentException("Enum doesn't exist");
	}
	
}
