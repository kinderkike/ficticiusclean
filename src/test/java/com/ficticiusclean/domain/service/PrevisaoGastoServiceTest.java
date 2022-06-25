package com.ficticiusclean.domain.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ficticiusclean.domain.model.PrevisaoGastoParametro;
import com.ficticiusclean.domain.model.Veiculo;

@RunWith(MockitoJUnitRunner.class)
public class PrevisaoGastoServiceTest {
	
	@Mock
	private VeiculoService veiculoService; 
	
	@InjectMocks
	private PrevisaoGastoService previsaoGastoService;
	
	@Test
	public void deveRetornarNenhumaPrevisaoDeGastoQuandoNaoPossuirVeiculos() {
		when(veiculoService.buscarTodos()).thenReturn(List.of());
		
		List<?> veiculos = previsaoGastoService.calcular(new PrevisaoGastoParametro());
		
		assertTrue(veiculos.isEmpty());
		verify(veiculoService).buscarTodos();
	}
	
	@Test
	public void deveRetornarUmaPrevisaoDeGastoQuandoPossuirUmVeiculo() {
		when(veiculoService.buscarTodos()).thenReturn(List.of(criaVeiculoComId(1l)));
		
		List<?> veiculos = previsaoGastoService.calcular(new PrevisaoGastoParametro());
		
		assertFalse(veiculos.isEmpty());
		assertEquals(1, veiculos.size(), 0);
		verify(veiculoService).buscarTodos();
	}
	
	private Veiculo criaVeiculoComId(long id) {
		Veiculo veiculoUm = new Veiculo();
		veiculoUm.setId(id);
		return veiculoUm;
	}

}
