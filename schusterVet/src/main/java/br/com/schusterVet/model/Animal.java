package br.com.schusterVet.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	
	private String nome;
	
	private String tipo;
	
	private String cor;
	
	private String raca;
	
	private Double peso;
	
	private String altura;
	
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "animal", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	List<Atendimento> atendimentos;
	
	@OneToMany(mappedBy = "animal", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	List<Responsavel> responsaveis;
	



	public Animal() {
		
		
	}
	
	
	
	
	public Animal(Long id, String nome, String tipo, String cor, String raca, Double peso, String altura,
			Date dataNascimento, List<Atendimento> atendimentos, List<Responsavel> responsaveis) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.cor = cor;
		this.raca = raca;
		this.peso = peso;
		this.altura = altura;
		this.dataNascimento = dataNascimento;
		this.atendimentos = atendimentos;
		this.responsaveis = responsaveis;
	}




	public Animal toAnimal() {
		
			Animal animal = new Animal();
			animal.setNome(this.nome);
			animal.setPeso(this.peso);
			animal.setCor(this.cor);
			animal.setRaca(this.raca);
			animal.setTipo(this.tipo);
			animal.setAltura(this.altura);
			animal.setDataNascimento(this.dataNascimento);

			return animal;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
		
	

	
}
