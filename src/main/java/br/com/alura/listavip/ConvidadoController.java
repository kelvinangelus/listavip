package br.com.alura.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	ConvidadoService service = new ConvidadoService();
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
				
		model.addAttribute("convidados", service.obterTodos()); //Envia a lista para a view
		
		return "listaconvidados";
	
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone,
			Model model) {
		
		Convidado novoConvidado = new Convidado(nome, email, telefone);
		
		service.salvar(novoConvidado);
		
		new EmailService().enviar(nome, email);
		
		/*
		Iterable<Convidado> convidados = repository.findAll();
		
		model.addAttribute("convidados", convidados); //Envia a lista para a view
		
		return "listaconvidados"; 
		
		*/
		
		return listaConvidados(model);
	}
	
	
}
