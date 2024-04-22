package com.teste.clienteseveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.clienteseveiculos.entity.VeiculoEntity;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {

}
