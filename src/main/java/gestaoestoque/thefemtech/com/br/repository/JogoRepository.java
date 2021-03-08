package gestaoestoque.thefemtech.com.br.repository;

import org.springframework.data.repository.CrudRepository;

import gestaoestoque.thefemtech.com.br.model.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, Integer>{

	void save(int id);

}
