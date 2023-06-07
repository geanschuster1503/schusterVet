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
	
	private String Descricao;
	
	@OneToMany(mappedBy = "atendimento", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	List<Profissional> profissionais;
	
	@OneToMany(mappedBy = "atendimento", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	List<Vacina> vacinas;

	
	
	
	

	public Atendimento() {
		
		
	}








	public Atendimento(Long id, Animal animal, LocalDateTime dataHora, String descricao,
			List<Profissional> profissionais, List<Vacina> vacinasa) {
		super();
		this.id = id;
		this.animal = animal;
		this.dataHora = dataHora;
		Descricao = descricao;
		this.profissionais = profissionais;
		this.vacinas = vacinas;
		
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
		return Descricao;
	}








	public void setDescricao(String descricao) {
		Descricao = descricao;
	}








	public List<Profissional> getProfissionais() {
		return profissionais;
	}








	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}








	public List<Vacina> getVacinas() {
		return vacinas;
	}








	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}



	
	
}
