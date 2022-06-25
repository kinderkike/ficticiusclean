package com.ficticiusclean.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficticiusclean.api.model.PrevisaoGastoParametroDTO;
import com.ficticiusclean.domain.model.PrevisaoGasto;
import com.ficticiusclean.domain.model.PrevisaoGastoParametro;
import com.ficticiusclean.domain.service.PrevisaoGastoService;

@RestController
@RequestMapping(path = "/previsao-gastos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrevisaoGastoController  {

	@Autowired
	private PrevisaoGastoService previsaoGastoService;
	
	@GetMapping
	public ResponseEntity<List<PrevisaoGasto>> calcular(@Valid @RequestBody PrevisaoGastoParametroDTO previsaoGastoParametroDTO) {
		List<PrevisaoGasto> veiculos = previsaoGastoService.calcular(criarPrevisaoGastoParametro(previsaoGastoParametroDTO));
		if (veiculos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(veiculos);
	}
	
	private PrevisaoGastoParametro criarPrevisaoGastoParametro(PrevisaoGastoParametroDTO previsaoGastoParametroDTO) {
		PrevisaoGastoParametro previsaoGastoParametro = new PrevisaoGastoParametro();
		previsaoGastoParametro.setPrecoCombustivel(previsaoGastoParametroDTO.getPrecoCombustivel());
		previsaoGastoParametro.setDistanciaKmCidade(previsaoGastoParametroDTO.getDistanciaKmCidade());
		previsaoGastoParametro.setDistanciaKmRodovia(previsaoGastoParametroDTO.getDistanciaKmRodovia());
		return previsaoGastoParametro;
	}
	
}
