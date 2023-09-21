package com.projetofarmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofarmacia.entities.Medicamento;
import com.projetofarmacia.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
		private final MedicamentoRepository medicamentoRepository;

		@Autowired
		public MedicamentoService (MedicamentoRepository medicamentoRepository) {
			this.medicamentoRepository = medicamentoRepository;
		}
		public List<Medicamento> buscaTodosMedicamento(){
			return medicamentoRepository.findAll();
		}

		public Medicamento getMedicamentoById(Long id) {
			Optional <Medicamento> Medicamento = medicamentoRepository.findById(id);
			return Medicamento.orElse(null);
		}

		public Medicamento saveMedicamento (Medicamento medicamento) {
			return medicamentoRepository.save(medicamento);
		}

		public Medicamento alteraMedicamento (Long id, Medicamento alteraMedicamento) {
			Optional <Medicamento> existeMedicamento = medicamentoRepository.findById(id);
			if(existeMedicamento.isPresent()) {
				alteraMedicamento.setId(id);
				return medicamentoRepository.save(alteraMedicamento);
			}
			return null;
		}

		public boolean apagarMedicamento(Long id) {
			Optional <Medicamento> existeMedicamento = medicamentoRepository.findById(id);
			if(existeMedicamento.isPresent()) {
				medicamentoRepository.deleteById(id);
				return true;
			}
			return false;

		}
	}


