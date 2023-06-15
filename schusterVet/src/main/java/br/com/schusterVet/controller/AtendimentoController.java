package br.com.schusterVet.controller;


import java.time.temporal.ChronoUnit;
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
import br.com.schusterVet.model.Atendimento;
import br.com.schusterVet.model.Profissional;
import br.com.schusterVet.model.Responsavel;
import br.com.schusterVet.model.Vacina;
import br.com.schusterVet.repository.AnimalRepository;
import br.com.schusterVet.repository.AtendimentoRepository;
import br.com.schusterVet.repository.ProfissionalRepository;
import br.com.schusterVet.repository.VacinaRepository;



@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Atendimento> atendimento = this.atendimentoRepository.findAll();
		model.addAttribute("atendimento", atendimento);
		return "WEB/atendimento/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		Atendimento atendimento = new Atendimento();
		List<Profissional> listProfissional = profissionalRepository.findAll();
		List<Vacina> listVacina  = vacinaRepository.findAll();
		List<Animal> listAnimal = animalRepository.findAll();
		model.addAttribute("listProfissional", listProfissional);
		model.addAttribute("listVacina", listVacina);

		model.addAttribute("listAnimal", listAnimal);
		model.addAttribute("atendimento", atendimento);
		return "WEB/atendimento/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Atendimento atendimento) {
		atendimento = atendimento.toAtendimento();
		atendimentoRepository.save(atendimento);
		return "redirect:/atendimento/lista";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id,Model model) {
	
		 Optional<Atendimento> optional = this.atendimentoRepository.findById(id);
		 
		 if (optional.isPresent()) {
			List<Profissional> listProfissional = profissionalRepository.findAll();
			List<Vacina> listVacina  = vacinaRepository.findAll();
			List<Animal> listAnimal = animalRepository.findAll();
			model.addAttribute("listProfissional", listProfissional);
			model.addAttribute("listVacina", listVacina);
			model.addAttribute("listAnimal", listAnimal);
			 Atendimento atendimento = optional.get();

			 
			 
			 
			 atendimento.fromAtendimento(atendimento);
			model.addAttribute(atendimento);
			
	    		return "WEB/atendimento/editar";
			}else {
				return"redirect:/atendimento/lista";	
			}
	}
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Atendimento> optional = this.atendimentoRepository.findById(id);
        
    	if (optional.isPresent()) {
			Atendimento atendimento= optional.get();

			model.addAttribute(atendimento);
    		return "WEB/atendimento/detalhes";
    		
		}else {
			return"redirect:/atendimento/lista";	
		}
    }
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Atendimento atendimento) {
		Optional<Atendimento> optional = this.atendimentoRepository.findById(id);
		if(optional.isPresent()) {
			
			atendimento.toAtendimentoAtualizar(optional.get());
			
			this.atendimentoRepository.save(atendimento);
		
		}
		
		return"redirect:/atendimento/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.atendimentoRepository.deleteById(id);
		 return"redirect:/atendimento/lista";
		
	}
}
