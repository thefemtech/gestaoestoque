package gestaoestoque.thefemtech.com.br.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gestaoestoque.thefemtech.com.br.model.Jogo;
import gestaoestoque.thefemtech.com.br.repository.JogoRepository;

@Controller
@RequestMapping("gestaoestoque")
public class EstoqueController {

	@Autowired
	JogoRepository jogoRepository;

	@RequestMapping(value = "/jogo", method = RequestMethod.POST)
	public ResponseEntity<?> cadastrarJogo(@RequestBody Jogo jogo) {
		try {
			jogoRepository.save(jogo);

			return new ResponseEntity<>(
				jogo, 
				HttpStatus.CREATED
			);
		} catch (Exception ex) {
			return new ResponseEntity<>(
				ex.getMessage(),
				HttpStatus.BAD_REQUEST
			);
		}
	}

	@RequestMapping(value = "/jogo/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable int id) {
		Optional<Jogo> jogo = jogoRepository.findById(id);

		return jogo.isPresent()
			? new ResponseEntity<>(
				jogo.get(), 
				HttpStatus.OK
			) : new ResponseEntity<>(
				"{ \"errorMessage\": \"Error game not found!\" }", 
				HttpStatus.NOT_FOUND
			);
	}

	@RequestMapping(value = "/jogo", method = RequestMethod.GET)
	public ResponseEntity<?> retornaJogos() {
		Iterable<Jogo> jogos = jogoRepository.findAll();

		return new ResponseEntity<>(
			jogos.iterator(),
			HttpStatus.OK
		);
	}

	@RequestMapping(value = "/jogo/disponiveis", method = RequestMethod.GET)
	public ResponseEntity<?> retornaJogosDisponiveis() {
		Iterable<Jogo> jogos = jogoRepository.findAll();

		ArrayList<Jogo> jogosRetorno = new ArrayList<Jogo>();
		jogos.forEach(jogoDisponivel -> {
			if(jogoDisponivel.getQuantidadeEstoque() > 0) {
				jogosRetorno.add(jogoDisponivel);
			}
		});

		return new ResponseEntity<>(
			jogosRetorno,
			HttpStatus.OK
		);
	}
}
