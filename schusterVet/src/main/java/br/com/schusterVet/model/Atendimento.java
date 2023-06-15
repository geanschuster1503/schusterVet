package br.com.schusterVet.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Atendimento {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	

	@ManyToOne
	@JoinColumn(name="animal_id")
	private Animal animal;
	
	private LocalDateTime dataHora;
	
	private String descricao;
	
	private String vacina;
	
	private String animalAtendimento;
	
	private String profissional;
	
	@OneToMany(mappedBy = "atendimento")
	List<Profissional> listaProfissional;
	
	@OneToMany(mappedBy = "atendimento")
	List<Vacina> listaVacina;

	
	public Atendimento toAtendimento() {
		
		Atendimento atendimento = new Atendimento();
		atendimento.setAnimalAtendimento(this.animalAtendimento);
		atendimento.setDataHora(this.dataHora);
		atendimento.setDescricao(this.descricao);
		atendimento.setProfissional(this.profissional);
		atendimento.setVacina(this.vacina);

		return atendimento;
	}

public Atendimento toAtendimentoAtualizar(Atendimento atendimento) {
	
	
	atendimento.setAnimalAtendimento(this.animalAtendimento);
	atendimento.setDataHora(this.dataHora);
	atendimento.setDescricao(this.descricao);
	atendimento.setProfissional(this.profissional);
	atendimento.setVacina(this.vacina);

	return atendimento;
}


public void fromAtendimento(Atendimento atendimento) {
	
	this.animalAtendimento=getAnimalAtendimento();
	this.dataHora=getDataHora();
	this.descricao=getDescricao();
	this.vacina=getVacina();
	this.profissional=getProfissional();
	
}
	
	

	public Atendimento() {
		
		
	}






	public Atendimento(Long id, Animal animal, LocalDateTime dataHora, String descricao,
			String profissional, String vacina) {
		super();
		this.id = id;
		this.animal = animal;
		this.dataHora = dataHora;
		this.descricao = descricao;
		this.profissional = profissional;
		this.vacina = vacina;
	}






	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public Animal getAnimal() {
		return animal;
	}






	public void setAnimal(Animal animal) {
		this.animal = animal;
	}






	public LocalDateTime getDataHora() {
		return dataHora;
	}






	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}






	public String getDescricao() {
		return descricao;
	}






	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public String getAnimalAtendimento() {
		return animalAtendimento;
	}

	public void setAnimalAtendimento(String animalAtendimento) {
		this.animalAtendimento = animalAtendimento;
	}







	

	
	
}
