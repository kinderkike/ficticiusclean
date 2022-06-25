package com.ficticiusclean.api.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
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

import com.ficticiusclean.api.model.VeiculoDTO;
import com.ficticiusclean.domain.model.Veiculo;
import com.ficticiusclean.domain.service.VeiculoService;

@RunWith(MockitoJUnitRunner.class)
public class VeiculoControllerTest {
	
	@Mock
	private VeiculoService veiculoService;

	@InjectMocks
	private VeiculoController veiculoController;
	
	@Test
	public void deveCadastrarUmVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(1l);
		when(veiculoService.cadastrar(Mockito.any())).thenReturn(veiculo);
		
		ResponseEntity<Veiculo> responseEntity = veiculoController.cadastrar(new VeiculoDTO());
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(veiculo, responseEntity.getBody());
	}

	@Test
	public void deveRetornarNenhumCalculo() {
		ResponseEntity<List<Veiculo>> responseEntity = veiculoController.listar();

		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void deveRetornarUmCalculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(1l);
		when(veiculoService.buscarTodos()).thenReturn(List.of(veiculo));

		ResponseEntity<List<Veiculo>> responseEntity = veiculoController.listar();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertThat(responseEntity.getBody(), 
				containsInAnyOrder(veiculo));
	}

}
