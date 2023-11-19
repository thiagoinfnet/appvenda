package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Ferramenta;

@Repository
public interface FerramentaRepository extends CrudRepository<Ferramenta, Integer> {
	void deleteByCodigo(Integer codigo);
}
