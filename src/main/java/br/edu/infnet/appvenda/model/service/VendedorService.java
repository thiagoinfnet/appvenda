package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;

	@Transactional
	public Vendedor incluir(Vendedor vendedor) {
	    return vendedorRepository.save(vendedor);
	}
	
    public Collection<Vendedor> obterLista() {
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

    public Vendedor obterPorId(Integer id) {
        Optional<Vendedor> optionalVendedor = vendedorRepository.findById(id);
        return optionalVendedor.orElse(null);
    }

    @Transactional
    public Vendedor atualizar(Integer id, Vendedor novoVendedor) {
        Optional<Vendedor> optionalVendedor = vendedorRepository.findById(id);
        if (optionalVendedor.isPresent()) {
            Vendedor vendedor = optionalVendedor.get();
            return vendedorRepository.save(vendedor);
        }
        return null;
    }

    @Transactional
    public void excluir(Integer id) {
        vendedorRepository.deleteById(id);
    }
}