package br.com.schusterVet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.schusterVet.model.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long>  {

}
