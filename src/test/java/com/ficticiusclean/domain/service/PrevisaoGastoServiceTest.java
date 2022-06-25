package com.ficticiusclean.domain.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ficticiusclean.domain.model.PrevisaoGasto;
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
	public void deveRetornarUmaPrevisaoDeGastoComDadosDoVeiculoQuandoPossuirUmVeiculo() {
		Veiculo veiculo = criarVeiculoRenegade();
		when(veiculoService.buscarTodos()).thenReturn(List.of(veiculo));

		PrevisaoGastoParametro previsaoGastoParametro = new PrevisaoGastoParametro();
		previsaoGastoParametro.setPrecoCombustivel(0.01);
		previsaoGastoParametro.setDistanciaKmCidade(0.01);
		previsaoGastoParametro.setDistanciaKmRodovia(0.01);
		List<PrevisaoGasto> veiculos = previsaoGastoService.calcular(previsaoGastoParametro);

		assertFalse(veiculos.isEmpty());
		assertEquals(1, veiculos.size(), 0);
		assertThat(veiculos, containsInAnyOrder(allOf(
				hasProperty("nome", is("Renegade")),
				hasProperty("marca", is("JEEP")),
				hasProperty("modelo", is("Limited")),
				hasProperty("anoFabricacao", is(2017))
				)));
		verify(veiculoService).buscarTodos();
	}
	
	@Test
	public void deveRetornarUmaPrevisaoDeGastoCalculadoQuandoPossuirUmVeiculo() {
		Veiculo veiculo = criarVeiculoRenegade();
		when(veiculoService.buscarTodos()).thenReturn(List.of(veiculo));
		
		PrevisaoGastoParametro previsaoGastoParametro = new PrevisaoGastoParametro();
		previsaoGastoParametro.setPrecoCombustivel(6.89);
		previsaoGastoParametro.setDistanciaKmCidade(8d);
		previsaoGastoParametro.setDistanciaKmRodovia(13d);
		
		List<PrevisaoGasto> veiculos = previsaoGastoService.calcular(previsaoGastoParametro);
		
		assertFalse(veiculos.isEmpty());
		assertEquals(1, veiculos.size(), 0);
		assertThat(veiculos, containsInAnyOrder(allOf(
				hasProperty("nome", is("Renegade")),
				hasProperty("marca", is("JEEP")),
				hasProperty("modelo", is("Limited")),
				hasProperty("anoFabricacao", is(2017)),
				hasProperty("volumeLitroCombustivel", is(criarNovoDecimal(2d))),
				hasProperty("gastoPrevisto", is(criarNovoDecimal(13.78)))
				)));
		verify(veiculoService).buscarTodos();
	}
	
	@Test
	public void deveRetornarDuasPrevisoesDeGastosCalculadosQuandoPossuirDoisVeiculos() {
		Veiculo veiculoRenegade = criarVeiculoRenegade();
		Veiculo veiculoFiesta = criarVeiculoFiesta();
		when(veiculoService.buscarTodos()).thenReturn(List.of(veiculoRenegade, veiculoFiesta));

		PrevisaoGastoParametro previsaoGastoParametro = new PrevisaoGastoParametro();
		previsaoGastoParametro.setPrecoCombustivel(6.89);
		previsaoGastoParametro.setDistanciaKmCidade(8d);
		previsaoGastoParametro.setDistanciaKmRodovia(13d);

		List<PrevisaoGasto> veiculos = previsaoGastoService.calcular(previsaoGastoParametro);

		assertFalse(veiculos.isEmpty());
		assertEquals(2, veiculos.size(), 0);
		assertThat(veiculos, containsInAnyOrder(
				allOf(
					hasProperty("nome", is("Renegade")),
					hasProperty("marca", is("JEEP")),
					hasProperty("modelo", is("Limited")),
					hasProperty("anoFabricacao", is(2017)),
					hasProperty("volumeLitroCombustivel", is(criarNovoDecimal(2d))),
					hasProperty("gastoPrevisto", is(criarNovoDecimal(13.78)))
				),
				allOf(
					hasProperty("nome", is("Fiesta")),
					hasProperty("marca", is("Ford")),
					hasProperty("modelo", is("SEL")),
					hasProperty("anoFabricacao", is(2017)),
					hasProperty("volumeLitroCombustivel", is(criarNovoDecimal(1.67))),
					hasProperty("gastoPrevisto", is(criarNovoDecimal(11.51)))
					)
				));
		verify(veiculoService).buscarTodos();
	}
	
	@Test
	public void deveRetornarVariasPrevisoesDeGastosCalculadosERanqueadosBaseadoNoValorGasto() {
		Veiculo veiculoRenegade = criarVeiculoRenegade();
		Veiculo veiculoFiesta = criarVeiculoFiesta();
		Veiculo veiculoUno = criarVeiculoUno();
		when(veiculoService.buscarTodos()).thenReturn(List.of(veiculoRenegade, veiculoFiesta, veiculoUno));
		
		PrevisaoGastoParametro previsaoGastoParametro = new PrevisaoGastoParametro();
		previsaoGastoParametro.setPrecoCombustivel(6.89);
		previsaoGastoParametro.setDistanciaKmCidade(8d);
		previsaoGastoParametro.setDistanciaKmRodovia(13d);
		
		List<PrevisaoGasto> veiculos = previsaoGastoService.calcular(previsaoGastoParametro);
		
		assertFalse(veiculos.isEmpty());
		assertEquals(3, veiculos.size(), 0);
		assertThat(veiculos, containsInRelativeOrder(
				allOf(
						hasProperty("nome", is("Uno")),
						hasProperty("marca", is("Fiat")),
						hasProperty("modelo", is("Sporting 1.4")),
						hasProperty("anoFabricacao", is(2013)),
						hasProperty("volumeLitroCombustivel", is(criarNovoDecimal(1.54))),
						hasProperty("gastoPrevisto", is(criarNovoDecimal(10.61)))
						),
				allOf(
						hasProperty("nome", is("Fiesta")),
						hasProperty("marca", is("Ford")),
						hasProperty("modelo", is("SEL")),
						hasProperty("anoFabricacao", is(2017)),
						hasProperty("volumeLitroCombustivel", is(criarNovoDecimal(1.67))),
						hasProperty("gastoPrevisto", is(criarNovoDecimal(11.51)))
						),
				allOf(
						hasProperty("nome", is("Renegade")),
						hasProperty("marca", is("JEEP")),
						hasProperty("modelo", is("Limited")),
						hasProperty("anoFabricacao", is(2017)),
						hasProperty("volumeLitroCombustivel", is(criarNovoDecimal(2d))),
						hasProperty("gastoPrevisto", is(criarNovoDecimal(13.78)))
						)
				));
		verify(veiculoService).buscarTodos();
	}
	
	private BigDecimal criarNovoDecimal(double valor) {
		return BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP);
	}

	private Veiculo criarVeiculoRenegade() {
		Veiculo veiculo = criaVeiculoComId(1l);
		veiculo.setNome("Renegade");
		veiculo.setMarca("JEEP");
		veiculo.setModelo("Limited");
		veiculo.setAnoFabricacao(2017);
		veiculo.setConsumoCidade(8d);
		veiculo.setConsumoRodovia(13d);
		return veiculo;
	}
	
	private Veiculo criarVeiculoFiesta() {
		Veiculo veiculo = criaVeiculoComId(2l);
		veiculo.setNome("Fiesta");
		veiculo.setMarca("Ford");
		veiculo.setModelo("SEL");
		veiculo.setAnoFabricacao(2017);
		veiculo.setConsumoCidade(10d);
		veiculo.setConsumoRodovia(15d);
		return veiculo;
	}
	
	private Veiculo criarVeiculoUno() {
		Veiculo veiculo = criaVeiculoComId(2l);
		veiculo.setNome("Uno");
		veiculo.setMarca("Fiat");
		veiculo.setModelo("Sporting 1.4");
		veiculo.setAnoFabricacao(2013);
		veiculo.setConsumoCidade(11d);
		veiculo.setConsumoRodovia(16d);
		return veiculo;
	}

	private Veiculo criaVeiculoComId(long id) {
		Veiculo veiculoUm = new Veiculo();
		veiculoUm.setId(id);
		return veiculoUm;
	}

}
