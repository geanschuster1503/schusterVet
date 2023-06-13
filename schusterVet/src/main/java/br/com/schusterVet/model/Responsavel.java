package br.com.schusterVet.model;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Responsavel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private String email;
	

	@ManyToOne
	@JoinColumn(name="responsavel_id")
	private Animal animal;

	
	public Responsavel toResponsavel() {
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNome(this.nome);
		responsavel.setCpf(this.cpf);
		responsavel.setTelefone(this.telefone);
		responsavel.setEmail(this.email);


		return responsavel;
	}

public Responsavel toResponsavelAtualizar(Responsavel responsavel) {
	
	
	responsavel.setNome(this.nome);
	responsavel.setCpf(this.cpf);
	responsavel.setTelefone(this.telefone);
	responsavel.setEmail(this.email);


	return responsavel;
}


public void fromResponsavel(Responsavel responsavel) {
	
	this.cpf=getCpf();
	this.email=getCpf();
	this.nome=getNome();
	this.telefone=getTelefone();


}
	
	public Responsavel() {
		
		
	}

	
	

	public Responsavel(Long id, String nome, String cpf, String telefone, String email, Animal animal) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		
		
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	
	
}
