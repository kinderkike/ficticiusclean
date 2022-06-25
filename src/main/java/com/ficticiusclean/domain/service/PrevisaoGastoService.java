package com.ficticiusclean.domain.service;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficticiusclean.domain.model.PrevisaoGasto;
import com.ficticiusclean.domain.model.PrevisaoGastoParametro;
import com.ficticiusclean.domain.model.Veiculo;

@Service
public class PrevisaoGastoService {
	
	private static final int CASAS_DECIMAIS = 2; 

	@Autowired
	private VeiculoService veiculoService;

	public List<PrevisaoGasto> calcular(PrevisaoGastoParametro previsaoGastoParametro) {
		List<PrevisaoGasto> previsoesGastos = new ArrayList<>();
		for (Veiculo veiculo : veiculoService.buscarTodos()) {
			previsoesGastos.add(calcularPrevisaoGasto(previsaoGastoParametro, veiculo));
		}
		previsoesGastos.sort(criarOrdenadorPorGastoPrevisto());
		return previsoesGastos;
	}

	private PrevisaoGasto calcularPrevisaoGasto(PrevisaoGastoParametro previsaoGastoParametro, Veiculo veiculo) {
		PrevisaoGasto previsaoGasto = new PrevisaoGasto();
		previsaoGasto.setNome(veiculo.getNome());
		previsaoGasto.setMarca(veiculo.getMarca());
		previsaoGasto.setModelo(veiculo.getModelo());
		previsaoGasto.setAnoFabricacao(veiculo.getAnoFabricacao());
		BigDecimal volumeNecessario = calcularVolumeNecessario(veiculo, previsaoGastoParametro);
		previsaoGasto.setVolumeLitroCombustivel(volumeNecessario);
		previsaoGasto.setGastoPrevisto(calcularGastoPrevisto(previsaoGastoParametro, volumeNecessario));
		return previsaoGasto;
	}

	private BigDecimal calcularVolumeNecessario(Veiculo veiculo, PrevisaoGastoParametro previsaoGastoParametro) {
		double volumeCidade = previsaoGastoParametro.getDistanciaKmCidade() / veiculo.getConsumoCidade();
		double volumeRodovia = previsaoGastoParametro.getDistanciaKmRodovia() / veiculo.getConsumoRodovia();
		return BigDecimal.valueOf(volumeCidade + volumeRodovia).setScale(CASAS_DECIMAIS, HALF_UP);
	}
	
	private BigDecimal calcularGastoPrevisto(PrevisaoGastoParametro previsaoGastoParametro, BigDecimal volumeNecessario) {
		return volumeNecessario.multiply(BigDecimal.valueOf(previsaoGastoParametro.getPrecoCombustivel())).setScale(CASAS_DECIMAIS, HALF_UP);
	}

	private Comparator<PrevisaoGasto> criarOrdenadorPorGastoPrevisto() {
		return new Comparator<PrevisaoGasto>() {
			public int compare(PrevisaoGasto previsaoGasto1, PrevisaoGasto previsaoGasto2) {
				return previsaoGasto1.getGastoPrevisto().compareTo(previsaoGasto2.getGastoPrevisto());
			}
		};
	}

}
