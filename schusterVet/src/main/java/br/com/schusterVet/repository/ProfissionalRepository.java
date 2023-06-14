package br.com.schusterVet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.schusterVet.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
