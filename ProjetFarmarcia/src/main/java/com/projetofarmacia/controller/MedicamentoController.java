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

import com.projetofarmacia.entities.Medicamento;
import com.projetofarmacia.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	private final MedicamentoService medicamentoService;

	@Autowired
	public  MedicamentoController (MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> getMedicamentoControlId(@PathVariable Long id){
		Medicamento medicamento = medicamentoService.getMedicamentoById(id);
		if(medicamento != null) {
			return ResponseEntity.ok(medicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Medicamento>> buscaTodosMedicamentoControl(){
		List<Medicamento> medicamento = medicamentoService.buscaTodosMedicamento();

		return ResponseEntity.ok(medicamento);
	}

	@PostMapping("/")
	public ResponseEntity<Medicamento> saveMedicamentoControl(@RequestBody Medicamento medicamento){
		Medicamento savemedicamento = medicamentoService.saveMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(savemedicamento);
	}



	@PutMapping("/{id}")
	public ResponseEntity<Medicamento> alteraMedicamentoControl(@PathVariable Long id, @RequestBody Medicamento medicamento){
		Medicamento alteraMedicamento = medicamentoService.alteraMedicamento(id, medicamento);
		if(alteraMedicamento !=null) {
			return ResponseEntity.ok(medicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarMedicamentoControl(@PathVariable Long id){
		boolean apagar = medicamentoService.apagarMedicamento(id);
		if(apagar) {
			return ResponseEntity.ok().body("O aposento foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
}