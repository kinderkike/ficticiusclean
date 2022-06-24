package com.ficticiusclean.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "MARCA", nullable = false)
	private String marca;

	@Column(name = "MODELO", nullable = false)
	private String modelo;

	@Column(name = "ANO_FABRICACAO", nullable = false)
	private int anoFabricacao;

	@Column(name = "CONSUMO_CIDADE", nullable = false)
	private double consumoCidade;

	@Column(name = "CONSUMO_RODOVIA", nullable = false)
	private double consumoRodovia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public double getConsumoCidade() {
		return consumoCidade;
	}

	public void setConsumoCidade(double consumoCidade) {
		this.consumoCidade = consumoCidade;
	}

	public double getConsumoRodovia() {
		return consumoRodovia;
	}

	public void setConsumoRodovia(double consumoRodovia) {
		this.consumoRodovia = consumoRodovia;
	}

}
