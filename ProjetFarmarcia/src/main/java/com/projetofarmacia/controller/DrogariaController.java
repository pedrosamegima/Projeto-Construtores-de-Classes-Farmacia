package com.projetofarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.projetofarmacia.entities.Drogaria;
import com.projetofarmacia.service.DrogariaService;

@RestController
@RequestMapping("/drogaria")
public class DrogariaController {
	private final DrogariaService drogariaService;

	@Autowired
	public DrogariaController (DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Drogaria> getDrogariaControlId(@PathVariable Long id){
		Drogaria drogaria = drogariaService.getDrogariaById(id);
		if(drogaria != null) {
			return ResponseEntity.ok(drogaria);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Drogaria>> buscaTodosAposentoControl(){
		List<Drogaria> drogaria = drogariaService.buscaTodosDrogaria();

		return ResponseEntity.ok(drogaria);
	}

	@PostMapping("/")
	public ResponseEntity<Drogaria> saveDrogariaControl(@RequestBody Drogaria drogaria){
		Drogaria savedrogaria = drogariaService.saveDrogaria(drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedrogaria);
	}



	@PutMapping("/{id}")
	public ResponseEntity<Drogaria> alteraDrogariaControl(@PathVariable Long id, @RequestBody Drogaria drogaria){
		Drogaria alteraDrogaria = drogariaService.alteraDrogaria(id, drogaria);
		if(alteraDrogaria !=null) {
			return ResponseEntity.ok(drogaria);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarDrogariaControl(@PathVariable Long id){
		boolean apagar = drogariaService.apagarDrogaria(id);
		if(apagar) {
			return ResponseEntity.ok().body("O aposento foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
}
