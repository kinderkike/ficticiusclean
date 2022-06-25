package com.ficticiusclean.api.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class PrevisaoGastoParametroDTO {
	
	@NotNull(message = "precoCombustivel é requerido")
	@DecimalMin(value = "0.1", message = "precoCombustivel deve ser maior ou igual a {value}")
	private Double precoCombustivel;
	
	@NotNull(message = "distanciaKmCidade é requerido")
	@DecimalMin(value = "0.1", message = "distanciaKmCidade deve ser maior ou igual a {value}")
	private Double distanciaKmCidade;
	
	@NotNull(message = "distanciaKmRodovia é requerido")
	@DecimalMin(value = "0.1", message = "distanciaKmRodovia deve ser maior ou igual a {value}")
	private Double distanciaKmRodovia;

	public Double getPrecoCombustivel() {
		return precoCombustivel;
	}

	public void setPrecoCombustivel(Double precoCombustivel) {
		this.precoCombustivel = precoCombustivel;
	}

	public Double getDistanciaKmCidade() {
		return distanciaKmCidade;
	}

	public void setDistanciaKmCidade(Double distanciaKmCidade) {
		this.distanciaKmCidade = distanciaKmCidade;
	}

	public Double getDistanciaKmRodovia() {
		return distanciaKmRodovia;
	}

	public void setDistanciaKmRodovia(Double distanciaKmRodovia) {
		this.distanciaKmRodovia = distanciaKmRodovia;
	}

}
