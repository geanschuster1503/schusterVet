package br.com.schusterVet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters.DateToLocalDateConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.schusterVet.model.Responsavel;
import br.com.schusterVet.model.Vacina;
import br.com.schusterVet.repository.VacinaRepository;

@Controller
@RequestMapping(value="/vacina")
public class VacinaController {
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Vacina> vacina = this.vacinaRepository.findAll();
		model.addAttribute("vacina", vacina);
		return "WEB/vacina/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		Vacina vacina = new Vacina();
		model.addAttribute("vacina", vacina);
		return "WEB/vacina/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Model model, Vacina vacina) {
		vacina = vacina.toVacina();
		vacinaRepository.save(vacina);

		return "redirect:/vacina/lista";
	}
	

	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id,Model model) {
	
		 Optional<Vacina> optional = this.vacinaRepository.findById(id);
		 
		 if (optional.isPresent()) {
			 Vacina vacina = optional.get();
			 vacina.fromVacina(vacina);
			model.addAttribute(vacina);
			
	    		return "WEB/vacina/editar";
			}else {
				return"redirect:/vacina/lista";	
			}
	}
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Vacina> optional = this.vacinaRepository.findById(id);
    	if (optional.isPresent()) {
			Vacina vacina = optional.get();
			model.addAttribute(vacina);
    		return "WEB/vacina/detalhes";
    		
		}else {
			return"redirect:/vacina/lista";	
		}
    }
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Vacina vacina) {
		Optional<Vacina> optional = this.vacinaRepository.findById(id);
		if(optional.isPresent()) {
			
			vacina.toVacinaAtualizar(optional.get());
			
			this.vacinaRepository.save(vacina);
		
		}
		
		return"redirect:/vacina/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.vacinaRepository.deleteById(id);
		 return"redirect:/vacina/lista";
		
	}

}
