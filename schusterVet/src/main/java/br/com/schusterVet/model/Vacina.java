package br.com.schusterVet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vacina {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="vacina_id")
	private Atendimento atendimento;
	
	public Vacina() {
		
		
	}
	
	

	public Vacina(Long id, String nome, Atendimento atendimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.atendimento = atendimento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	
}
