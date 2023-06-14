package br.com.schusterVet.model;


import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

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
	
	
	private String validade;
	
	private Long lote;
	
	@ManyToOne
	@JoinColumn(name="vacina_id")
	private Atendimento atendimento;
	
	public Vacina toVacina() {
		
		Vacina vacina = new Vacina();
		
		vacina.setNome(this.nome);
		vacina.setLote(this.lote);
		vacina.setValidade(this.validade);
		return vacina;
	}
	
	public Vacina toVacinaAtualizar(Vacina vacina) {
		
		
		vacina.setNome(this.nome);
		vacina.setLote(this.lote);
		vacina.setValidade(this.validade);
		return vacina;
	}
	
	public void fromVacina(Vacina vacina) {
		
		this.nome=getNome();
		this.lote=getLote();
		this.validade=getValidade();

	}
	
	public Vacina() {
		
		
	}
	
	

	



	public Vacina(Long id, String nome, String validade, Long lote, Atendimento atendimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.validade = validade;
		this.lote = lote;
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

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Long getLote() {
		return lote;
	}

	public void setLote(Long lote) {
		this.lote = lote;
	}
	
	
}
