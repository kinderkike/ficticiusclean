package com.ficticiusclean.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ficticiusclean.api.model.VeiculoDTO;
import com.ficticiusclean.domain.model.Veiculo;
import com.ficticiusclean.domain.service.VeiculoService;

@RestController
@RequestMapping(path = "/veiculos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VeiculoController  {

	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo cadastrar(@Valid @RequestBody VeiculoDTO veiculoDTO) {
		return veiculoService.cadastrar(criarVeiculo(veiculoDTO));
	}

	@GetMapping
	public ResponseEntity<List<Veiculo>> listar() {
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		if (veiculos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(veiculos);
	}
	
	private Veiculo criarVeiculo(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = new Veiculo();
		veiculo.setNome(veiculoDTO.getNome());
		veiculo.setMarca(veiculoDTO.getMarca());
		veiculo.setModelo(veiculoDTO.getModelo());
		veiculo.setAnoFabricacao(veiculoDTO.getAnoFabricacao());
		veiculo.setConsumoCidade(veiculoDTO.getConsumoCidade());
		veiculo.setConsumoRodovia(veiculoDTO.getConsumoRodovia());
		return veiculo;
	}
	
}
