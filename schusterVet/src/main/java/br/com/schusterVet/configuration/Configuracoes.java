package br.com.schusterVet.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.schusterVet.model.Animal;

@Configuration
public class Configuracoes {

	
	@Bean
	public Animal animal() {
		
		return new Animal();
	}
	
	
}
