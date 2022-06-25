package com.ficticiusclean.domain.service;

import static org.mockito.Mockito.verify;

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
		Veiculo veiculo = new Veiculo();
		veiculo.setId(1l);
		
		veiculoService.cadastrar(veiculo);
		
		verify(veiculoRepository).save(veiculo);
	}

}