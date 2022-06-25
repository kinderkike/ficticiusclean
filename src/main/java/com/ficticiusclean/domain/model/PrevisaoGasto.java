package com.ficticiusclean.domain.model;

public class PrevisaoGasto {

	private String nome;
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Double volumeLitroCombustivel;
	private Double gastoPrevisto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Double getVolumeLitroCombustivel() {
		return volumeLitroCombustivel;
	}

	public void setVolumeLitroCombustivel(Double volumeLitroCombustivel) {
		this.volumeLitroCombustivel = volumeLitroCombustivel;
	}

	public Double getGastoPrevisto() {
		return gastoPrevisto;
	}

	public void setGastoPrevisto(Double gastoPrevisto) {
		this.gastoPrevisto = gastoPrevisto;
	}

}
