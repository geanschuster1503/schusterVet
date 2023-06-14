package br.com.schusterVet.model;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Profissional {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String funcao;
	
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name="atendimento_id")
	private Atendimento atendimento;

	
	public Profissional() {
		
		
	}


	public Profissional toProfissional() {
		
		Profissional profissional = new Profissional();
		profissional.setNome(this.nome);
		profissional.setCpf(this.cpf);
		profissional.setFuncao(this.funcao);
		profissional.setAtivo(this.ativo);


		return profissional;
	}

public Profissional toProfissionalAtualizar(Profissional profissional) {
	
	
	profissional.setNome(this.nome);
	profissional.setCpf(this.cpf);
	profissional.setFuncao(this.funcao);
	profissional.setAtivo(this.ativo);


	return profissional;
}


public void fromProfissional(Profissional profissional) {
	
	this.cpf=getCpf();
	this.ativo=getAtivo();
	this.nome=getNome();
	this.funcao=getFuncao();


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


public String getFuncao() {
	return funcao;
}


public void setFuncao(String funcao) {
	this.funcao = funcao;
}


public Boolean getAtivo() {
	return ativo;
}


public void setAtivo(Boolean ativo) {
	this.ativo = ativo;
}


public Atendimento getAtendimento() {
	return atendimento;
}


public void setAtendimento(Atendimento atendimento) {
	this.atendimento = atendimento;
}

	
}
