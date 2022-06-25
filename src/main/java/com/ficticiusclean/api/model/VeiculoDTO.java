package com.ficticiusclean.api.model;

import javax.validation.constraints.NotNull;

public class VeiculoDTO {
	
	@NotNull(message = "nome é requerido")
	private String nome;
	
	@NotNull(message = "marca é requerida")
	private String marca;
	
	@NotNull(message = "modelo é requerido")
	private String modelo;
	
	@NotNull(message = "anoFabricacao é requerido")
	private Integer anoFabricacao;
	
	@NotNull(message = "consumoCidade é requerido")
	private Double consumoCidade;
	
	@NotNull(message = "consumoRodovia é requerido")
	private Double consumoRodovia;

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

	public Double getConsumoCidade() {
		return consumoCidade;
	}

	public void setConsumoCidade(Double consumoCidade) {
		this.consumoCidade = consumoCidade;
	}

	public Double getConsumoRodovia() {
		return consumoRodovia;
	}

	public void setConsumoRodovia(Double consumoRodovia) {
		this.consumoRodovia = consumoRodovia;
	}

}
