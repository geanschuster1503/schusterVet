package br.com.schusterVet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.schusterVet.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	
	
}
