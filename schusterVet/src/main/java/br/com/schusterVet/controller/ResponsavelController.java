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

import br.com.schusterVet.model.Animal;
import br.com.schusterVet.model.Responsavel;
import br.com.schusterVet.repository.ResponsavelRepository;
import br.com.schusterVet.service.ResponsavelService;


@Controller
@RequestMapping(value="/responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelService responsavelService;
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Responsavel> responsavel = this.responsavelRepository.findAll();
		model.addAttribute("responsavel", responsavel);
		return "WEB/responsavel/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		Responsavel responsavel = new Responsavel();
		model.addAttribute("responsavel", responsavel);
		return "WEB/responsavel/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Model model, Responsavel responsavel) {
		responsavel = responsavel.toResponsavel();
			responsavelRepository.save(responsavel);

		return "redirect:/responsavel/lista";
	}
	

	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id,Model model) {
	
		 Optional<Responsavel> optional = this.responsavelRepository.findById(id);
		 
		 if (optional.isPresent()) {
			 Responsavel responsavel = optional.get();
			 responsavel.fromResponsavel(responsavel);
			model.addAttribute(responsavel);
			
	    		return "WEB/responsavel/editar";
			}else {
				return"redirect:/responsavel/lista";	
			}
	}
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Responsavel> optional = this.responsavelRepository.findById(id);
    	if (optional.isPresent()) {
			Responsavel responsavel = optional.get();
			model.addAttribute(responsavel);
    		return "WEB/responsavel/detalhes";
    		
		}else {
			return"redirect:/responsavel/lista";	
		}
    }
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Responsavel responsavel) {
		Optional<Responsavel> optional = this.responsavelRepository.findById(id);
		if(optional.isPresent()) {
			
			responsavel.toResponsavelAtualizar(optional.get());
			
			this.responsavelRepository.save(responsavel);
		
		}
		
		return"redirect:/responsavel/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.responsavelRepository.deleteById(id);
		 return"redirect:/responsavel/lista";
		
	}
	
}
