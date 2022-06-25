package com.ficticiusclean.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ficticiusclean.api.model.PrevisaoGastoParametroDTO;
import com.ficticiusclean.domain.model.PrevisaoGasto;
import com.ficticiusclean.domain.model.PrevisaoGastoParametro;
import com.ficticiusclean.domain.service.PrevisaoGastoService;

@RunWith(MockitoJUnitRunner.class)
public class PrevisaoGastoControllerTest {

	@Mock
	private PrevisaoGastoService previsaoGastoService;

	@InjectMocks
	private PrevisaoGastoController previsaoGastoController;

	@Test
	public void deveRetornarNenhumCalculo() {
		PrevisaoGastoParametroDTO previsaoGastoParametroDTO = criaPrevisaoGastoParametroDTO();

		ResponseEntity<List<PrevisaoGasto>> responseEntity = previsaoGastoController.calcular(previsaoGastoParametroDTO);

		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void deveRetornarUmCalculo() {
		PrevisaoGastoParametroDTO previsaoGastoParametroDTO = criaPrevisaoGastoParametroDTO();
		List<PrevisaoGasto> previsoesGastos = List.of(new PrevisaoGasto());
		when(previsaoGastoService.calcular(Mockito.any(PrevisaoGastoParametro.class))).thenReturn(previsoesGastos);

		ResponseEntity<List<PrevisaoGasto>> responseEntity = previsaoGastoController.calcular(previsaoGastoParametroDTO);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(previsoesGastos, responseEntity.getBody());
	}

	private PrevisaoGastoParametroDTO criaPrevisaoGastoParametroDTO() {
		PrevisaoGastoParametroDTO previsaoGastoParametroDTO = new PrevisaoGastoParametroDTO();
		previsaoGastoParametroDTO.setPrecoCombustivel(1d);
		previsaoGastoParametroDTO.setDistanciaKmCidade(1d);
		previsaoGastoParametroDTO.setDistanciaKmRodovia(1d);
		return previsaoGastoParametroDTO;
	}

}
