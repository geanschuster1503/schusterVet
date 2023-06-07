package br.com.schusterVet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class AtendimentoController {

	
	@GetMapping("/atendimento/lista")
	public String lista() {
		
		return "WEB/atendimento/lista";
	}
	
	@GetMapping("/atendimento/novo")
	public String novo(Model model) {
		
		
		
		return "WEB/atendimento/novo";
	}
}
