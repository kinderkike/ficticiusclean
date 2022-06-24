package com.ficticiusclean.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficticiusclean.domain.model.Veiculo;
import com.ficticiusclean.domain.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo cadastrar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public List<Veiculo> buscarTodos() {
		return veiculoRepository.findAll();
	}

}
