package com.projetofarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofarmacia.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository <Medicamento, Long> {

}
