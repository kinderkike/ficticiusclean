package com.ficticiusclean.api.model;

import javax.validation.constraints.NotNull;

public class PrevisaoGastoParametroDTO {
	
	@NotNull(message = "precoCombustivel é requerido")
	private Double precoCombustivel;
	
	@NotNull(message = "consumoCidade é requerido")
	private Double distanciaKmCidade;
	
	@NotNull(message = "consumoRodovia é requerido")
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
