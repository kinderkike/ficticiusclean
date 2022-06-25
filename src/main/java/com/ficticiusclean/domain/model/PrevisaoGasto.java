package com.ficticiusclean.domain.model;

import java.math.BigDecimal;

public class PrevisaoGasto {

	private String nome;
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private BigDecimal volumeLitroCombustivel;
	private BigDecimal gastoPrevisto;

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

	public BigDecimal getVolumeLitroCombustivel() {
		return volumeLitroCombustivel;
	}

	public void setVolumeLitroCombustivel(BigDecimal volumeLitroCombustivel) {
		this.volumeLitroCombustivel = volumeLitroCombustivel;
	}

	public BigDecimal getGastoPrevisto() {
		return gastoPrevisto;
	}

	public void setGastoPrevisto(BigDecimal gastoPrevisto) {
		this.gastoPrevisto = gastoPrevisto;
	}

}
