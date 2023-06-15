package br.com.schusterVet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.schusterVet.model.Profissional;
import br.com.schusterVet.model.Responsavel;
import br.com.schusterVet.repository.ProfissionalRepository;
import br.com.schusterVet.repository.ResponsavelRepository;
import br.com.schusterVet.service.ResponsavelService;

@Controller
@RequestMapping(value="/profissional")
public class ProfissionalController {

	
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Profissional> profissional = this.profissionalRepository.findAll();
		model.addAttribute("profissional", profissional);
		return "WEB/profissional/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		Profissional profissional = new Profissional();
		model.addAttribute("profissional", profissional);
		return "WEB/profissional/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Model model, Profissional profissional) {
		profissional = profissional.toProfissional();
		profissionalRepository.save(profissional);
		return "redirect:/profissional/lista";
	}
	

	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id,Model model) {
	
		 Optional<Profissional> optional = this.profissionalRepository.findById(id);
		 if (optional.isPresent()) {
			 Profissional profissional = optional.get();
			 profissional.fromProfissional(profissional);
			model.addAttribute(profissional);
	    		return "WEB/profissional/editar";
			}else {
				return"redirect:/profissional/lista";	
			}
	}
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Profissional> optional = this.profissionalRepository.findById(id);
    	if (optional.isPresent()) {
    		Profissional profissional = optional.get();
			model.addAttribute(profissional);
    		return "WEB/profissional/detalhes";
    		
		}else {
			return"redirect:/profissional/lista";	
		}
    }
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Profissional profissional) {
		Optional<Profissional> optional = this.profissionalRepository.findById(id);
		if(optional.isPresent()) {
			profissional.toProfissionalAtualizar(optional.get());
			this.profissionalRepository.save(profissional);
		
		}
		
		return"redirect:/profissional/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.profissionalRepository.deleteById(id);
		 return"redirect:/profissional/lista";
		
	}
	
}
