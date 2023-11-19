package br.edu.infnet.appvenda.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import feign.Param;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {
    @Query("SELECT v FROM Vendedor v WHERE LOWER(v.nome) LIKE %:termo% OR LOWER(v.cpf) LIKE %:termo%")
    Collection<Vendedor> buscarPorTermo(@Param("termo") String termo);
}
