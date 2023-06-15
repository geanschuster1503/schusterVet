package br.com.schusterVet.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.schusterVet.model.Animal;
import br.com.schusterVet.model.Atendimento;
import br.com.schusterVet.model.Responsavel;
import br.com.schusterVet.model.Vacina;

@Configuration
public class Configuracoes {

	
	@Bean
	public Animal animal() {
		
		return new Animal();
	}
	
	@Bean
	public Responsavel responsavel() {
		
		return new Responsavel();
	}
	
	@Bean
	public Vacina vacina() {
		
		return new Vacina();
	}
	
	@Bean
	public Atendimento atendimento() {
		
		return new Atendimento();
	}
}
