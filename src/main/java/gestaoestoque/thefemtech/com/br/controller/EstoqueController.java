package gestaoestoque.thefemtech.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gestaoestoque.thefemtech.com.br.model.Jogo;
import gestaoestoque.thefemtech.com.br.repository.JogoRepository;

@Controller
@RequestMapping("gestaoestoque")
public class EstoqueController {
	
	@Autowired
	JogoRepository jogoRepository;
	
	@RequestMapping(value="/jogo", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> cadastrarJogo(@RequestBody Jogo jogo){
		try {
			jogoRepository.save(jogo);
			return ResponseEntity.created(null).build();
		} catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value="/jogo", method=RequestMethod.GET)
	//@ResponseBody
	public ResponseEntity<?> teste(){
		String teste = "hello";
		return ResponseEntity.ok(teste);
	}
	
	
	

}
