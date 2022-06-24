package com.ficticiusclean.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ficticiusclean.domain.model.Veiculo;
import com.ficticiusclean.domain.repository.VeiculoRepository;

@Repository
public interface VeiculoRepositoryImpl extends JpaRepository<Veiculo, Long>, VeiculoRepository {

}
