package com.projetofarmacia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String bula;
	
	@NotNull
	@NotBlank
	@Size(max = 12)
	private int attribute12;
	
	
	@Future
	private String dataValidade;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getNome() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
