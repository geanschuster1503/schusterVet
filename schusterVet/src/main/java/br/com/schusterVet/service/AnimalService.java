package br.com.schusterVet.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.schusterVet.model.Animal;

@Service
public class AnimalService {

	@Autowired
	private Animal animal;
	

}
