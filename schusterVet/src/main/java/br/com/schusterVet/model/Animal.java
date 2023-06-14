package br.com.schusterVet.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	private String peso;
	
	private String altura;
	
	private LocalDate dataNascimento;
	
	private LocalDate anoAtual = LocalDate.of(2023, 06, 12);
	
	private Long idade;
	
	private String responsavelAnimal;
	
	
	@OneToMany(mappedBy = "animal")
	List<Atendimento> atendimentos;
	
	@OneToMany(mappedBy = "animal")
	List<Responsavel> responsavel = new ArrayList<>();
	
	

	public Animal() {
		
		
	}
	
	
	
	
	public Animal(Long id, String nome, String tipo, String cor, String raca, String peso, String altura,
			LocalDate dataNascimento, List<Atendimento> atendimentos, List<Responsavel> responsavel, Long idade, String responsavelAnimal) {
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
		this.responsavel = responsavel;
		this.idade=idade;
		this.responsavelAnimal=responsavelAnimal;
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
			animal.setResponsavelAnimal(this.responsavelAnimal);
			return animal;
		}
	
	public Animal toAnimalAtualizar(Animal animal) {
		
		
		animal.setNome(this.nome);
		animal.setPeso(this.peso);
		animal.setCor(this.cor);
		animal.setRaca(this.raca);
		animal.setTipo(this.tipo);
		animal.setAltura(this.altura);
		animal.setDataNascimento(this.dataNascimento);
		animal.setResponsavelAnimal(this.responsavelAnimal);

		return animal;
	}
	
	
	public void fromAnimal(Animal animal) {
		
		this.altura=getAltura();
		this.cor=getCor();
		this.nome=getNome();
		this.peso=getPeso();
		this.raca=getRaca();
		this.tipo=getTipo();
		this.dataNascimento=getDataNascimento();
		this.responsavelAnimal=getResponsavelAnimal();
		
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

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}




	public List<Responsavel> getResponsavel() {
		return responsavel;
	}




	public void setResponsavel(List<Responsavel> responsavel) {
		this.responsavel = responsavel;
	}




	public Long getIdade() {
		return idade;
	}




	public void setIdade(long idade) {
		this.idade = idade;
	}




	public LocalDate getAnoAtual() {
		return anoAtual;
	}




	public void setAnoAtual(LocalDate anoAtual) {
		this.anoAtual = anoAtual;
	}




	public String getResponsavelAnimal() {
		return responsavelAnimal;
	}




	public void setResponsavelAnimal(String responsavelAnimal) {
		this.responsavelAnimal = responsavelAnimal;
	}
		
	

	
}
