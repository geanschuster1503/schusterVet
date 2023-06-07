package br.com.schusterVet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.schusterVet.model.Animal;
import br.com.schusterVet.repository.AnimalRepository;
import br.com.schusterVet.service.AnimalService;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Animal> animal = this.animalRepository.findAll();
		model.addAttribute("animal", animal);
		return "WEB/animal/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		Animal animal = new Animal();
		model.addAttribute("animal", animal);
		return "WEB/animal/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Animal animal) {
		animal = animal.toAnimal();
		animalRepository.save(animal);
		return "redirect:/animal/novo";
	}
	
}
