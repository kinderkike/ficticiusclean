package com.ficticiusclean.api.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VeiculoDTO {
	
	@NotEmpty(message = "nome é requerido")
	private String nome;
	
	@NotEmpty(message = "marca é requerida")
	private String marca;
	
	@NotEmpty(message = "modelo é requerido")
	private String modelo;
	
	@NotNull(message = "anoFabricacao é requerido")
	@Min(value = 1700, message = "anoFabricacao deve ser maior ou igual a {value}")
	private Integer anoFabricacao;
	
	@NotNull(message = "consumoCidade é requerido")
	@DecimalMin(value = "0.1", message = "consumoCidade deve ser maior ou igual a {value}")
	private Double consumoCidade;
	
	@NotNull(message = "consumoRodovia é requerido")
	@DecimalMin(value = "0.1", message = "consumoRodovia deve ser maior ou igual a {value}")
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
