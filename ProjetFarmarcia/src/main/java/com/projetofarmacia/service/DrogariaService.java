package com.projetofarmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofarmacia.entities.Drogaria;
import com.projetofarmacia.repository.DrogariaRepository;



@Service
public class DrogariaService {
	private final DrogariaRepository drogariaRepository;
	
	@Autowired
	public DrogariaService (DrogariaRepository drogariaRepository) {
		this.drogariaRepository = drogariaRepository;
	}
	public List<Drogaria> buscaTodosDrogaria(){
		return drogariaRepository.findAll();
	}
	
	public Drogaria getDrogariaById(Long id) {
		Optional <Drogaria> Drogaria = drogariaRepository.findById(id);
		return Drogaria.orElse(null);
	}
	
	public Drogaria saveDrogaria (Drogaria drogaria) {
		return drogariaRepository.save(drogaria);
	}
	
	public Drogaria alteraDrogaria (Long id, Drogaria alteraDrogaria) {
		Optional <Drogaria> existeDrogaria = drogariaRepository.findById(id);
		if(existeDrogaria.isPresent()) {
			alteraDrogaria.setId(id);
			return drogariaRepository.save(alteraDrogaria);
		}
		return null;
	}
	
	public boolean apagarDrogaria(Long id) {
		Optional <Drogaria> existeDrogaria = drogariaRepository.findById(id);
		if(existeDrogaria.isPresent()) {
			drogariaRepository.deleteById(id);
			return true;
		}
		return false;
	
	}

}
