package com.ficticiusclean.domain.repository;

import java.util.List;

import com.ficticiusclean.domain.model.Veiculo;

public interface VeiculoRepository {
	
	Veiculo save(Veiculo veiculo);
	List<Veiculo> findAll();

}
