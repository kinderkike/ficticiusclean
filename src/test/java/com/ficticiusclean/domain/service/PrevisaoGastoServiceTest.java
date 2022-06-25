package com.ficticiusclean.domain.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ficticiusclean.domain.model.PrevisaoGastoParametro;

@RunWith(MockitoJUnitRunner.class)
public class PrevisaoGastoServiceTest {
	
	@Mock
	private VeiculoService veiculoService; 
	
	@InjectMocks
	private PrevisaoGastoService previsaoGastoService;
	
	@Test
	public void deveRetornarNenhumCalculoQuandoNaoPossuirVeiculos() {
		List<?> veiculos = previsaoGastoService.calcular(new PrevisaoGastoParametro());
		
		assertTrue(veiculos.isEmpty());
	}

}
