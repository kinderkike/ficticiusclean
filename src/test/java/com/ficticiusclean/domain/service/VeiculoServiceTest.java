package com.ficticiusclean.domain.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
		Veiculo veiculo = new Veiculo();
		veiculo.setId(1l);
		
		veiculoService.cadastrar(veiculo);
		
		verify(veiculoRepository).save(veiculo);
	}
	
	@Test
	public void deveListarNenhumVeiculo() {
		Mockito.when(veiculoRepository.findAll()).thenReturn(List.of());
		
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		
		assertTrue(veiculos.isEmpty());
		verify(veiculoRepository).findAll();
	}

}