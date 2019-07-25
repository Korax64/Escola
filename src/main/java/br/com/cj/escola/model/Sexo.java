package br.com.cj.escola.model;

public enum Sexo {
MASCULINO("masculino"),FEMININO("feminino");
	
	private String descricao;

	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
