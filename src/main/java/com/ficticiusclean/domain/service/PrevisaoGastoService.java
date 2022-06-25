package com.ficticiusclean.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficticiusclean.domain.model.PrevisaoGasto;
import com.ficticiusclean.domain.model.PrevisaoGastoParametro;
import com.ficticiusclean.domain.model.Veiculo;

@Service
public class PrevisaoGastoService {
	
	@Autowired
	private VeiculoService veiculoService;
	
	public List<PrevisaoGasto> calcular(PrevisaoGastoParametro previsaoGastoParametro) {
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		
		List<PrevisaoGasto> previsoesGastos = new ArrayList<>();
		
		for (Veiculo veiculo : veiculos) {
			previsoesGastos.add(new PrevisaoGasto());
		}
		
		return previsoesGastos;
	}

}
