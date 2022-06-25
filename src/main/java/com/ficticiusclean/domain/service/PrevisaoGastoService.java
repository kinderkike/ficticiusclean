package com.ficticiusclean.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		return BigDecimal.valueOf(volumeCidade + volumeRodovia).setScale(2, RoundingMode.HALF_UP);
	}
	
	private BigDecimal calcularGastoPrevisto(PrevisaoGastoParametro previsaoGastoParametro, BigDecimal volumeNecessario) {
		return volumeNecessario.multiply(BigDecimal.valueOf(previsaoGastoParametro.getPrecoCombustivel())).setScale(2, RoundingMode.HALF_UP);
	}

	private Comparator<PrevisaoGasto> criarOrdenadorPorGastoPrevisto() {
		return new Comparator<PrevisaoGasto>() {
			public int compare(PrevisaoGasto o1, PrevisaoGasto o2) {
				return o1.getGastoPrevisto().compareTo(o2.getGastoPrevisto());
			}
		};
	}

}
