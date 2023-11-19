package br.edu.infnet.appvenda.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Produto;
import feign.Param;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	@Query("from Produto p where p.vendedor.id = :vendedorId")
	Collection<Produto> obterLista(Integer vendedorId);
	
    @Query("SELECT p FROM Produto p WHERE LOWER(p.descricao) LIKE %:termo% OR LOWER(p.codigo) LIKE %:termo%")
    Collection<Produto> buscarPorTermo(@Param("termo") String termo);
    
    void deleteByCodigo(Integer codigo);
}
