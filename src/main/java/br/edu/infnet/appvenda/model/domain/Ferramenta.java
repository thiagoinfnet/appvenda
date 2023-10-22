package br.edu.infnet.appvenda.model.domain;

public class Ferramenta extends Produto {
	private String tipo;
	private String dimensoes;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), tipo, dimensoes);
	}
}
