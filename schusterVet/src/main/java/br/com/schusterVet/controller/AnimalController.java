package br.com.schusterVet.controller;



import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.schusterVet.model.Animal;
import br.com.schusterVet.model.Responsavel;
import br.com.schusterVet.repository.AnimalRepository;
import br.com.schusterVet.repository.ResponsavelRepository;
import br.com.schusterVet.service.AnimalService;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	

	@GetMapping("/lista")
	public String lista(Model model) {
		List<Animal> animal = this.animalRepository.findAll();
		model.addAttribute("animal", animal);
		return "WEB/animal/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		Animal animal = new Animal();
		List<Responsavel> list = responsavelRepository.findAll();
		model.addAttribute("list", list);
		model.addAttribute("animal", animal);
		return "WEB/animal/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Animal animal) {
		animal = animal.toAnimal();
		animal.setIdade(ChronoUnit.YEARS.between(animal.getDataNascimento(), animal.getAnoAtual()));
		
		animalRepository.save(animal);
		return "redirect:/animal/lista";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id,Model model) {
	
		 Optional<Animal> optional = this.animalRepository.findById(id);
		 
		 if (optional.isPresent()) {
			List<Responsavel> list = responsavelRepository.findAll();
			model.addAttribute("list", list);
			 Animal animal = optional.get();
			 animal.setIdade(ChronoUnit.YEARS.between(animal.getDataNascimento(), animal.getAnoAtual()));
			 animal.fromAnimal(animal);
			model.addAttribute(animal);
			
	    		return "WEB/animal/editar";
			}else {
				return"redirect:/animal/lista";	
			}
	}
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Animal> optional = this.animalRepository.findById(id);
        
    	if (optional.isPresent()) {
			Animal animal = optional.get();
			animal.setIdade(ChronoUnit.YEARS.between(animal.getDataNascimento(), animal.getAnoAtual()));
			model.addAttribute(animal);
    		return "WEB/animal/detalhes";
    		
		}else {
			return"redirect:/animal/lista";	
		}
    }
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Animal animal) {
		Optional<Animal> optional = this.animalRepository.findById(id);
		if(optional.isPresent()) {
			
			animal.toAnimalAtualizar(optional.get());
			
			this.animalRepository.save(animal);
		
		}
		
		return"redirect:/animal/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.animalRepository.deleteById(id);
		 return"redirect:/animal/lista";
		
	}
	
}
