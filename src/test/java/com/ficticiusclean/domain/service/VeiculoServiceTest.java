package com.ficticiusclean.domain.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ficticiusclean.domain.model.Veiculo;
import com.ficticiusclean.domain.repository.VeiculoRepository;

@RunWith(MockitoJUnitRunner.class)
public class VeiculoServiceTest {
	
	@Mock
	private VeiculoRepository veiculoRepository;
	
	@InjectMocks
	private VeiculoService veiculoService; 
	
	@Test
	public void deveSalvarVeiculo() {
		Veiculo veiculo = criaVeiculoComId(1l);
		
		veiculoService.cadastrar(veiculo);
		
		verify(veiculoRepository).save(veiculo);
	}
	
	@Test
	public void deveListarNenhumVeiculo() {
		when(veiculoRepository.findAll()).thenReturn(List.of());
		
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		
		assertTrue(veiculos.isEmpty());
		verify(veiculoRepository).findAll();
	}
	
	@Test
	public void deveListarUmVeiculo() {
		Veiculo veiculo = criaVeiculoComId(1l);
		when(veiculoRepository.findAll()).thenReturn(List.of(veiculo));
		
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		
		Assert.assertFalse(veiculos.isEmpty());
		Assert.assertEquals(1l, veiculos.size(), 0);
		assertThat(veiculos, containsInAnyOrder(veiculo));
		verify(veiculoRepository).findAll();
	}
	
	@Test
	public void deveListarDoisVeiculos() {
		Veiculo veiculoUm = criaVeiculoComId(1l);
		Veiculo veiculoDois = criaVeiculoComId(2l);
		when(veiculoRepository.findAll()).thenReturn(List.of(veiculoUm, veiculoDois));
		
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		
		assertFalse(veiculos.isEmpty());
		assertEquals(2l, veiculos.size(), 0);
		assertThat(veiculos, containsInAnyOrder(
				veiculoUm,
				veiculoDois));
		verify(veiculoRepository).findAll();
	}

	private Veiculo criaVeiculoComId(long id) {
		Veiculo veiculoUm = new Veiculo();
		veiculoUm.setId(id);
		return veiculoUm;
	}

}