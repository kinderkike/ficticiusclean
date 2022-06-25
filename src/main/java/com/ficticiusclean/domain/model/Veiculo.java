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
	private Integer anoFabricacao;

	@Column(name = "CONSUMO_CIDADE", nullable = false)
	private Double consumoCidade;

	@Column(name = "CONSUMO_RODOVIA", nullable = false)
	private Double consumoRodovia;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
